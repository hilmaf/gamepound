import React, { useEffect, useState } from 'react';
import styled from 'styled-components';

const StyledAllDiv = styled.div`
    width: 100%;
`;
const StyledUpdateDiv = styled.div`
    height: 700px;
    margin-top: 40px;
    & > div{
        border-bottom: 1px solid #ebebeb;
        padding-top: 20px;
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

const UpdatePage = () => {

    const [detailUpdateVoList, setDetailUpdateVoList] = useState([]);

    useEffect(()=>{
        fetch("http://127.0.0.1:8889/gamepound/project/detail/update?no=1")
        .then((resp)=>{return resp.json()})
        .then((data)=>{
            console.log(data[0]);
            setDetailUpdateVoList(data);
        })
        .catch((e)=>{console.log("오류 : " + e);})
        ;
    }, []);

    return (<StyledAllDiv>
        <StyledUpdateDiv>
            {
                detailUpdateVoList.map((vo)=>{
                    return (<>
                    <div>
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
                    </>);
                })
            }
        </StyledUpdateDiv>
    </StyledAllDiv>);
};

export default UpdatePage;