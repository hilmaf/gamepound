import React from 'react';
import styled from 'styled-components';

const StyledAllDiv = styled.div`
    width: 100%;
`;
const StyledUpdateDiv = styled.div`
    height: 700px;
    & > ul{
        margin-right: 20px;
        padding-top: 70px;
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
        </StyledUpdateDiv>
    </StyledAllDiv>);
};

export default PrelaunchUpdatePage;