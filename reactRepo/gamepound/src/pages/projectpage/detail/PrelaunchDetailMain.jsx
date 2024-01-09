import React from 'react';
import { Link, Route, Routes } from 'react-router-dom';
import PrelaunchStoryPage from "./PrelaunchStoryPage";
import PrelaunchUpdatePage from "./PrelaunchUpdatePage";
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
        padding-top: 50px;
        width: 100%;
        height: 100%;
        display: grid;
        grid-template-columns: 3fr 2fr;
        grid-template-rows: 1fr;
        & > img{
            background-color: black;
        }
        & > ul{
            width: 100%;
            height: 600px;
            margin-left: 30px;
            & > li:nth-child(2){
                font-size: 35px;
                font-weight: 500;
                margin-bottom: 20px;
            }
            & > li > table{
                width: 100%;
                & > tbody > tr > td:nth-child(1){
                    width: 80px;
                }
                & > tbody > tr > td:nth-child(2){
                    padding-top: 8px;
                }
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
    height: 50px;
    display: flex;
    align-items: center;
    position: sticky;
    top: 126px;
    z-index: 9;
    background-color: #fff;
    & > div > div{
        width: 100%;
        height: 100%;
        display: flex;
        place-items: left center;
        font-size: 16px;
        & > span{
            margin-left: 5px;
            margin-right: 25px;
            & > a{
                color: lightgray;
            }
        }
    }
`;

const StyledProjectSelectDiv = styled.div`
    width: 100%;
    display: flex;
    justify-content: center;
`;


const PrelaunchDetailMain = () => {
    return (<StyledAllDiv>
        <StyledProjectDetailDiv>
            <div className="inner">
                
                <div>
                    <img src="" alt="프로젝트 대표 이미지" />
                    <ul>
                        <li>서브카테고리</li>
                        <li>공개예정 프로젝트 타이틀</li>
                        <li>
                            <table>
                                <tbody>
                                    <tr>
                                        <td>목표금액</td>
                                        <td>500,000원</td>
                                    </tr>
                                    <tr>
                                        <td>공개예정</td>
                                        <td>22024년 1월 15일</td>
                                    </tr>
                                </tbody>
                            </table>
                        </li>
                    </ul>
                </div>
            </div>
        </StyledProjectDetailDiv>
        <StyledProjectDetailNaviDiv>
            <div className="inner">
                <div>
                    <span><Link to="/project/detail/prelaunch/story">프로젝트 계획</Link></span>
                    <span><Link to="/project/detail/prelaunch/update">업데이트</Link></span>
                </div>
            </div>
        </StyledProjectDetailNaviDiv>
        <StyledProjectSelectDiv>
            <Routes>
                <Route path='/story' element={<PrelaunchStoryPage/>}></Route>
                <Route path='/update' element={<PrelaunchUpdatePage/>}></Route>
            </Routes>   
        </StyledProjectSelectDiv>
    </StyledAllDiv>);
};

export default PrelaunchDetailMain;