import React, { useEffect, useState } from 'react';
import CommunityPage from "./CommunityPage";
import StoryPage from "./StoryPage";
import UpdatePage from "./UpdatePage";
import { NavLink, useParams } from 'react-router-dom';
import styled from 'styled-components';

const StyledAllDiv = styled.div`
    width: 100%;
    .inner {
        width: 1200px;
        margin: 0 auto;
    }
`;
const StyledProjectDetailDiv = styled.div`
    display: flex;
    flex-direction: column;
    height: auto;
    margin-bottom: 40px;
    & .inner div:nth-child(1){
        width: 100%;
        margin-top: 10px;
        & > div{
            display: flex;
            justify-content: center;
            align-items: center;
            & > div{
                width: auto;
                background-color: #a1a1a115;
                border: 0.5px solid #8888886a;
                border-radius: 4px;
                padding: 7px;
                font-size: 14px;
            }
        }
        & > h1{
            display: flex;
            justify-content: center;
            align-items: center;
            margin-top: 20px;
        }
    }
    & .inner div:nth-child(2){
        padding-top: 50px;
        width: 100%;
        height: 100%;
        display: grid;
        grid-template-columns: 3fr 2fr;
        grid-template-rows: 1fr;
        & > span{
            width: 100%;
            height: 100%;
            background-color: var(--red-color);
            & > img{
                width: 100%;
                height: 100%;
                object-fit: cover;
            }
        }
        & > ul{
            width: 100%;
            height: 550px;
            margin-left: 30px;
            & > li:nth-child(2n){
                font-size: 40px;
                margin-bottom: 25px;
                margin-top: 5px;
                & > span{
                    font-size: 16px;
                }
                & > span:nth-child(2){
                    font-size: 20px;
                    margin-left: 13px;
                }
                
            }
            & > li > table{
                margin-top: 25px;
                width: 85%;
                border-top: 1px solid #ececec;
                
                & > tbody > tr > td:nth-child(2){
                    padding-left: 25px;
                    padding-top: 8px;
                }
                & > tbody > tr:nth-child(2){
                    & > td > span{
                        border-radius: 5px;
                        background-color: #f05a5a1a;
                        padding-left: 5px;
                        padding-right: 5px;
                        margin-left: 5px;
                        color: var(--red-color);
                    }
                }
            }
            & > li > button{
                width: 85%;
                height: 60px;
                font-size: 16px;
                color: white;
                background-color: var(--red-color);
                font-weight: 500;
                border-radius: 5px;
                margin-top: 40px;
            }
            & > li:last-child{
                margin: 0px;
            }
        }
    }
`;
const StyledProjectDetailNaviDiv = styled.div`
    width: 100%;
    border-top: 1px solid #ececec;
    border-bottom: 1px solid #ececec;
    height: 40px;
    display: flex;
    align-items: center;
    position: sticky;
    top: 126px;
    z-index: 9;
    background-color: #fff;
    & > div {
        & > div{
            width: 100%;
            display: flex;
            place-items: left center;
            font-size: 16px;
            & > span{
                padding-left: 5px;
                padding-right: 25px;
                & > a{
                    color: lightgray;
                    &.active{
                        font-weight: 500;
                        color: #333;
                    }
                }
            }

        }
    }
`;
const StyledProjectSelectDiv = styled.div`
    width: 100%;
    display: flex;
    justify-content: center;
    & > div{
        width: 1200px;
        display: grid;
        grid-template-rows: 1fr;
        grid-template-columns: 7fr 3fr;
        & > div:last-child{
            width: 100%;
            height: auto;
            & > div:first-child{
                // 창작자 소개 상자
                border: 1px solid #d6d6d6;
                border-radius: 5px;
                padding: 25px;
                margin-top: 60px;
                height: fit-content;
                margin-bottom: 20px;
                & > div:first-child{
                    font-size: 18px;
                    font-weight: 500;
                    margin-bottom: 20px;
                }
                & > div:nth-child(2){
                    display: flex;
                    align-items: center;
                    margin-bottom: 10px;
                    & > div{
                        width: 40px;
                        height: 40px;
                        font-size: 5px;
                        & > img{
                            width: 100%;
                            height: 100%;
                            object-fit: cover;
                        }
                    }
                    & > span{
                        font-weight: 500;
                        margin-left: 40px;
                    }
                }
            }
            & > div:last-child{
                //리워드 공간
                width: 100%;
                & > div{
                    //리워드 박스
                    border: 1px solid #d6d6d6;
                    border-radius: 5px;
                    padding: 25px;
                    margin-bottom: 10px;
                    & > div:first-child{
                        //가격부분
                        font-size: 23px;
                        font-weight: 500;
                        margin-bottom: 7px;
                    }
                }
            }
        }
    }
`;


const DetailMain = () => {

    
    const {temp, no} = useParams();
    console.log("DetailMain useParams ::: ",temp);
    console.log("DetailMain useParams ::: ",no);
    ///////////////////////////////////////////

    const [detailVo, setDetailVo] = useState([]);
    const [rewardVoList, setRewardVoList] = useState([]);

    useEffect(()=>{
        fetch("http://127.0.0.1:8889/gamepound/project/detail?no=" + no)
        .then((resp)=>{return resp.json()})
        .then((data)=>{
            setDetailVo(data);
            setRewardVoList(data.rewardVoList)
        })
        .catch((e)=>{console.log("오류 : " + e);})
        ;
    }, [no]);

    return (<StyledAllDiv>
        <StyledProjectDetailDiv>
            <div className="inner">
                <div>
                    <div><div>{detailVo.subCategory}</div></div>
                    <h1>{detailVo.title}</h1>
                </div>            
                <div>
                    <span><img src="" alt="프로젝트 대표 이미지" /></span>
                    <ul>
                        <li>모인금액</li>
                        <li>{detailVo.currentAmount} <span>원</span><span>{detailVo.achievementRate}%</span></li>
                        <li>남은시간</li>
                        <li>{detailVo.remainingPeriod} <span>일</span></li>
                        <li>후원자</li>
                        <li>{detailVo.totalBackerNo} <span>명</span></li>
                        <li>
                            <table>
                                <tbody>
                                    <tr>
                                        <td>목표금액</td>
                                        <td>{detailVo.goalAmount}원</td>
                                    </tr>
                                    <tr>
                                        <td>펀딩 기간</td>
                                        <td>{detailVo.startDateStr} ~ {detailVo.endDateStr} <span>{detailVo.achievementRate}일 남음</span></td>
                                    </tr>
                                    <tr>
                                        <td>결제</td>
                                        <td>목표금액 달성시 {detailVo.calDate}에 결제 진행</td>
                                    </tr>
                                </tbody>
                            </table>
                        </li>
                        <li><button>이 프로젝트 후원하기</button></li>
                    </ul>
                </div>
            </div>
        </StyledProjectDetailDiv>
        <StyledProjectDetailNaviDiv>
            <div className="inner">
                <div>
                    <span><NavLink to={`/project/detail/story/${no}`}>프로젝트 계획</NavLink></span>
                    <span><NavLink to={`/project/detail/update/${no}`}>업데이트</NavLink></span>
                    <span><NavLink to={`/project/detail/community/${no}`}>커뮤니티</NavLink></span>
                </div>
            </div>
        </StyledProjectDetailNaviDiv>
        <StyledProjectSelectDiv>
            <div>
                {temp === 'story' ? <StoryPage/> : null}
                {temp === 'update' ? <UpdatePage/> : null}
                {temp === 'community' ? <CommunityPage/> : null}
                <div>
                    <div>
                        <div>창작자 소개</div>
                        <div>
                            <div><img src={detailVo.memberPic} alt="창작자 프로필 이미지" /></div>
                            <span>{detailVo.memberName}</span>
                        </div>
                        <div>
                            {detailVo.memberIntro}
                        </div>
                    </div>
                    <div>
                    {
                        rewardVoList.map((vo)=>{
                            return(
                                <div key={vo.no}>
                                    <div>{vo.amount}원 + </div>
                                    <div>{vo.name}</div>
                                </div>
                            );
                        })
                    }
                    </div>
                </div>
            </div>
        </StyledProjectSelectDiv>
    </StyledAllDiv>);
};

export default DetailMain;