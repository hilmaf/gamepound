import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import styled from 'styled-components';

const StyledAllDiv = styled.div`
    width: 100%;
`;
const StyledUpdateDiv = styled.div`
    height: 700px;
    margin-top: 20px;

    //업데이트 없을때
    .communityNull{
        border: none;
        height: 400px;
        display: flex;
        align-items: center;
        justify-content: center;
        flex-direction: column;
        & > div:first-child{
            background-color: #e6e6e6;
            width: 70px;
            height: 70px;
            border-radius: 50px;
            display: flex;
            justify-content: center;
            align-items: center;
            & > svg{
                width: 40px;
                height: 40px;
                filter: invert(100%) sepia(100%) saturate(0%) hue-rotate(288deg) brightness(102%) contrast(102%);
            }
        }
        & > div:last-child{
            color: #e6e6e6;
            margin-top: 10px;
        }
    }

    & > div{
        border-bottom: 1px solid #ebebeb;
        padding-top: 40px;
        margin: 15px;
        & > ul{
            margin-right: 20px;
            & > li:nth-child(1){
                display: flex;
                margin-bottom: 20px;
                & > div:nth-child(1){
                    width: 40px;
                    height: 40px;
                    font-size: 5px;
                    margin-right: 20px;
                    & > img{
                        width: 100%;
                        height: 100%;
                        object-fit: cover;
                    }
                }
            }
        }
    }
`;
/////////////////////////////////////////////////////////////////////////////
const PrelaunchUpdatePage = () => {

    const {no} = useParams();

    const [detailPrelaunchUpdateVoList, setDetailPrelaunchUpdateVoList] = useState([]);

    useEffect(()=>{
        fetch("http://127.0.0.1:8889/gamepound/project/detail/prelaunch/update?no=" + no)
        .then((resp)=>{return resp.json()})
        .then((data)=>{
            setDetailPrelaunchUpdateVoList(data);
        })
        .catch((e)=>{console.log("오류 : " + e);})
        ;
    }, [no]);

    return (
        <StyledAllDiv>
            <StyledUpdateDiv>
                {
                    detailPrelaunchUpdateVoList.length == 0
                    ?
                    <div className='communityNull'>
                        <div>
                            <svg xmlns="http://www.w3.org/2000/svg" id="Layer_1" data-name="Layer 1" viewBox="0 0 24 24">
                                <path d="m12.5,12h1.586c.936,0,1.814-.364,2.475-1.025l6.707-6.707c.473-.472.732-1.1.732-1.768s-.26-1.296-.732-1.768c-.975-.975-2.561-.975-3.535,0l-6.707,6.707c-.651.651-1.025,1.554-1.025,2.475v1.586c0,.276.224.5.5.5Zm.5-2.086c0-.658.267-1.302.732-1.768l6.707-6.707c.584-.585,1.537-.585,2.121,0,.283.283.439.66.439,1.061s-.156.777-.439,1.061l-6.707,6.707c-.472.472-1.1.732-1.768.732h-1.086v-1.086Zm-1,6.086c0-.552.448-1,1-1s1,.448,1,1-.448,1-1,1-1-.448-1-1Zm-7-1c.552,0,1,.448,1,1s-.448,1-1,1-1-.448-1-1,.448-1,1-1Zm5,1c0,.552-.448,1-1,1s-1-.448-1-1,.448-1,1-1,1,.448,1,1Zm14-3.5v6c0,2.481-2.019,4.5-4.5,4.5H4.5c-2.481,0-4.5-2.019-4.5-4.5v-6c0-2.481,2.019-4.5,4.5-4.5h5c.276,0,.5.224.5.5s-.224.5-.5.5h-5c-1.93,0-3.5,1.57-3.5,3.5v6c0,1.93,1.57,3.5,3.5,3.5h15c1.93,0,3.5-1.57,3.5-3.5v-6c0-1.246-.671-2.408-1.75-3.032-.239-.138-.321-.444-.183-.683s.446-.32.683-.182c1.388.802,2.25,2.296,2.25,3.897Z"/>
                            </svg>
                        </div>
                        <div>
                        게시글이 없습니다.
                        </div>
                    </div>
                    :
                    detailPrelaunchUpdateVoList.map((vo)=>{
                        return (
                        <div key={vo.no}>
                            <ul>
                                <li>
                                    <div>
                                        <img src={vo.memberPic} alt="프로필 이미지" />
                                    </div>
                                    <div>
                                        <div>{vo.memberName}</div>
                                        <div>{vo.enrollDate}</div>
                                    </div>
                                </li>
                                <li>
                                    <div>{vo.content}</div>
                                </li>
                            </ul>
                        </div>
                        );
                    })
                }
            </StyledUpdateDiv>
        </StyledAllDiv>
    );
};

export default PrelaunchUpdatePage;