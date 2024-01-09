import React from 'react';
import styled from 'styled-components';

const StyledAllDiv = styled.div`
    width: 1200px;
`;
const StyledUpdateDiv = styled.div`
    display: grid;
    grid-template-columns: 7fr 3fr;
    grid-template-rows: 1fr;
    height: 700px;

    & > ul{
        margin-right: 20px;
        padding-top: 50px;

        & > li:nth-child(1){
            display: flex;
            margin-bottom: 20px;
            & > div:nth-child(1){
                width: 40px;
                height: 40px;
                font-size: 5px;
                margin-right: 20px;
            }
        }
    }

    & > div{
        border: 1px solid #d6d6d6;
        border-radius: 5px;
        padding: 25px;
        margin-top: 40px;
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



const PrelaunchUpdatePage = () => {
    return (<StyledAllDiv>
        <StyledUpdateDiv>
            <ul>
                <li>
                    <div><img src="" alt="프로필 이미지" /></div>
                    <div>
                        <div>창작자 명</div>
                        <div>작성일자</div>
                    </div>
                </li>
                <li>
                    <div>업데이트 내용</div>
                </li>
            </ul>
            <div>
                <div>창작자 소개</div>
                <div>
                    <div><img src="" alt="창작자 프로필 이미지" /></div>
                    <span>창작자 명</span>
                </div>
                <button>창작자 문의</button>
            </div>
        </StyledUpdateDiv>
    </StyledAllDiv>);
};

export default PrelaunchUpdatePage;