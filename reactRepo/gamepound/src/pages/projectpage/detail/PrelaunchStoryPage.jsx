import React from 'react';
import styled from 'styled-components';

const StyledAllDiv = styled.div`
    width: 1200px;
`;
const StyledNaviDiv = styled.div`
    width: 100%;
    height: 60px;
    position: sticky;
    top: 179px;
    z-index: 9;
    background-color: white;
    display: flex;
    place-items: center start;
    font-size: 16px;
    & > div{
        font-size: 14px;
        font-weight: 400;
        border: 1px solid #cfcfcf;
        padding: 6px;
        padding-left: 15px;
        padding-right: 15px;
        border-radius: 50px;
        margin-left: 5px;
        margin-right: 15px;
    }
`;
const StyledStoryDiv = styled.div`
    & > div:nth-child(1){
        background-color: #4eb56b26;
        width: fit-content;
        padding: 15px;
    }
    & > div{
        margin-top: 50px;
        & > div{
            margin-top: 20px;
        }
    }
`;



const PrelaunchStoryPage = () => {
    return (<StyledAllDiv>
        <StyledNaviDiv>
            <div>소개</div>
            <div>팀 소개</div>
            <div>선물 설명</div>
        </StyledNaviDiv>
        <StyledStoryDiv>
            <div>❗ 해당 프로젝트 정보는 미리 보기 용으로 상세 내용은 펀딩 시작 전 변경될 수 있습니다.</div>

            <div>
                <div>| 프로젝트 소개</div>
                <div>받아온 프로젝트 소개 내용</div>
            </div>
            <div>
                <div>| 팀 소개</div>
                <div>받아온 프로젝트 팀 소개 내용</div>
            </div>
            <div>
                <div>| 선물 설명</div>
                <div>받아온 프로젝트 선물 설명 내용</div>
            </div>
            
        </StyledStoryDiv>
    </StyledAllDiv>);
};

export default PrelaunchStoryPage;