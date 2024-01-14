import React, { useState } from 'react';
import styled from 'styled-components';
import {useUserMemory} from '../../component/context/UserContext';

const StyledReviewWriteDiv = styled.div`
    width: 1200px;
    height: 350px;
    margin: auto;
    margin-top: 30px;
    padding: 30px;
    border-top: 1px solid rgba(0, 0, 0, 0.1);

    & > form {

        & > #title {
            color: var(--red-color);
            font-size: 16px;
        }

        & > .writer_area {
            height: 60px;
            display: flex;
            align-items: center;

            & > img {
                width: 25px;
                height: 25px;
                border-radius: 25px;
                margin-right: 10px;
                background-color: aliceblue;
            }

            & > span {
                font-size: 14px;
            }
        }

        & > .content {
            width: 1000px;

            & > textarea {
                width: 700px;
                height: 100px;
                border: 1px solid var(--black-color);
                resize: none;
                border-radius: 5px;
            }
        }

        & > .upload {
            width: 700px;
            padding-top: 10px;
            display: flex;
            
            & > #upload_area {
                font-size: 14px;
                display: flex;
                flex-direction: column;

                & > label {
                    margin-top: 10px;
                    width: 70px;
                    height: 30px;
                    border: 1px solid var(--black-color);
                    border-radius: 5px;
                    background-color: var(--black-color);
                    color: white;
                    cursor: pointer;
                    text-align: center;
                    line-height: 30px;
            }
            }

            & > #img_preview {
                    width: 200px;
                    height: 133px;
                    border: 1px dashed rgba(0, 0, 0, 0.1);
                    margin-left: 40px;
            }

            
        }

        & > button {
            width: 70px;
            height: 30px;
            background-color: white;
            color: var(--red-color);
            border: 1px solid var(--red-color);
            border-radius: 5px;
            margin-left: 630px;
            cursor: pointer;

            &:hover {
                background-color: var(--red-color);
                color: white;
            }
        }
    }
`;

const ReviewWrite = ({item}) => {

    const {loginMemberVo} = useUserMemory();
    console.log(loginMemberVo);
    const [reviewVo, setReviewVo] = useState({
        memberNo: loginMemberVo.no,
        backNo: item.backNo
    });

    console.log(reviewVo);
    
    // img preview
    const handleInputChange = (event) => {
        const {name, value} = event.target;
        setReviewVo({
            ...reviewVo,
            [name]: value
        })
    }

    // fetch 리뷰 등록
    const handleReviewSubmit = (e) => {
        e.preventDefault();
        
        fetch("http://127.0.0.1:8889/gamepound/userpage/review/write", {
            method: "post",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(reviewVo)
        })
        .then(resp => resp.json())
        .then(data => {
            console.log(data);  
        })
    }

    return (
        <StyledReviewWriteDiv>
            <form>
                <div id='title'>
                    후기 작성
                </div>
                <div className='writer_area'>
                    <img src={loginMemberVo.pic} />
                    <span>{loginMemberVo.name}</span>
                </div>
                <div className='content'>
                    <textarea name='reviewContent' onChange={handleInputChange}></textarea>
                </div>
                <input type='file' id='inputImg' name='reviewImg' accept='image/*' hidden onChange={handleInputChange}/>
                <div className='upload'>
                    <div id='upload_area'>
                    이미지 업로드
                    <label htmlFor='inputImg'>사진 첨부</label>
                    </div>
                    <img id='img_preview' src=''></img>
                </div>
                <button onClick={handleReviewSubmit}>
                    후기 등록
                </button>
            </form>
        </StyledReviewWriteDiv>
    );
};

export default ReviewWrite;