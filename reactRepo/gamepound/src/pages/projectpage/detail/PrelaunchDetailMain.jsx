import React from 'react';
import { Route, Routes } from 'react-router-dom';
import PrelaunchStoryPage from "./PrelaunchStoryPage";
import PrelaunchUpdatePage from "./PrelaunchUpdatePage";
import styled from 'styled-components';

const StyledProjectDetailDiv = styled.div`
    width: 100%;
    height: auto;
    & > div:nth-child(2){
        width: 100%;
        height: 100%;
        display: grid;
        grid-template-columns: 1fr 1fr;
        grid-template-rows: 1fr;
    }
`;


const PrelaunchDetailMain = () => {
    return (<>
        <StyledProjectDetailDiv>
            <div>
                <div>카테고리 명</div>
                <h1>프로젝트 제목</h1>
            </div>            
            <div>
                <img src="" alt="프로젝트 대표 이미지" />
                <ul>
                    <li>모인금액</li>
                    <li>남은시간</li>
                    <li>후원자</li>
                    <li>결제관련</li>
                </ul>
            </div>
        </StyledProjectDetailDiv>
        <Routes>
            <Route path='/story' element={<PrelaunchStoryPage/>}></Route>
            <Route path='/update' element={<PrelaunchUpdatePage/>}></Route>
        </Routes>              
    </>);
};

export default PrelaunchDetailMain;