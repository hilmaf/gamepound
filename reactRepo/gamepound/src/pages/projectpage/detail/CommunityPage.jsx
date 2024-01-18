import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import styled from 'styled-components';

const StyledAllDiv = styled.div`
    width: 100%;
`;
const StyledCommunityDiv = styled.div`
    height: 700px;
    margin-top: 20px;
    & > div{
        padding-top: 20px;
        margin: 15px;
        & > ul{
            & > li:first-child{
                & > div:first-child{
                    display: flex;
                    padding-top: 20px;
                    align-items: center;
                    & > div:first-child{
                        margin-right: 15px;
                    }
                }
                & > div > div > img{
                    width: 40px;
                    height: 40px;
                    font-size: 5px;
                    object-fit: cover;
                }
                & > div:last-child{
                    padding: 15px 0px 15px 0px;
                }
            }
            & > li:last-child{
                padding: 15px;
                margin-left: 25px;
                & > div:first-child{
                    margin-bottom: 15px;
                }
            }
        }
    }
`;


const CommunityPage = () => {

    const {no} = useParams();

    const [detailCommunityVoList, setDetailCommunityVoList] = useState([]);

    useEffect(()=>{
        fetch("http://127.0.0.1:8889/gamepound/project/detail/community?no=" + no)
        .then((resp)=>{return resp.json()})
        .then((data)=>{
            setDetailCommunityVoList(data);
        })
        .catch((e)=>{console.log("오류 : " + e);})
        ;
    }, [no]);

    return (
        <StyledAllDiv>
            <StyledCommunityDiv>
                {
                    detailCommunityVoList.map((vo)=>{
                        return (
                        <div key={vo.no}>
                            <ul>
                                <li>
                                    <div>
                                        <div>
                                            <img src={vo.memberPid} alt="프로필 이미지" />
                                        </div>
                                        <div>
                                            <div>{vo.memberName}</div>
                                            <div>{vo.contentEnrollDate}</div>
                                        </div>
                                    </div>
                                    <div>{vo.content}</div>
                                </li>
                                <li>
                                    <div>
                                        <div>{vo.memberName}</div>
                                        <div>{vo.replyEnrollDate}</div>
                                    </div>
                                    <div>{vo.reply}</div>
                                </li>
                            </ul>
                        </div>
                        );
                    })
                }
            </StyledCommunityDiv>
        </StyledAllDiv>
    );
};

export default CommunityPage;