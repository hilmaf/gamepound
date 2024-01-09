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
        cursor: pointer;
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
    display: grid;
    grid-template-columns: 7fr 3fr;
    grid-template-rows: 1fr;

    & > ul{
        & > li:nth-child(2n){
            font-size: 19px;
            font-weight: 500;
            padding-top: 60px;
            padding-bottom: 60px;
        }
        & > li:last-child{
            padding-bottom: 100px;
        }
        & > li:nth-child(1){
            background-color: #4eb56b2b;
            padding: 20px;
            width: fit-content;
            margin-top: 40px;
            margin-bottom: 40px;
        }
    }

    & > div{
        border: 1px solid #d6d6d6;
        border-radius: 5px;
        padding: 25px;
        height: fit-content;
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
            }
            & > span{
                font-weight: 500;
                margin-left: 40px;
            }
        }
        & > button{
                padding: 10px;
                font-size: 15px;
                border: 1px solid #d6d6d6;
                border-radius: 5px;
                background-color: white;
                width: 100%;
                cursor: pointer;
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
            <ul>
                <li>❗ 해당 프로젝트 정보는 미리 보기 용으로 상세 내용은 펀딩 시작 전 변경될 수 있습니다.</li>
                <li>| 프로젝트 소개</li>
                <li>받아온 프로젝트 소개 내용</li>
                <li>| 팀 소개</li>
                <li>받아온 프로젝트 팀 소개 내용</li>
                <li>| 선물 설명</li>
                <li>받아온 프로젝트 선물 설명 내용</li>
            </ul>
            <div>
                <div>창작자 소개</div>
                <div>
                    <div><img src="" alt="창작자 프로필 이미지" /></div>
                    <span>창작자 명</span>
                </div>
                <button>창작자 문의</button>
            </div>
        </StyledStoryDiv>
    </StyledAllDiv>);
};

export default PrelaunchStoryPage;