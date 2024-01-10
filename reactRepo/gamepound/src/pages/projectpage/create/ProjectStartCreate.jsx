import React from 'react';
import { useNavigate } from 'react-router-dom';
import styled from 'styled-components';

const StyledCreateStartDiv = styled.div`
    & .inner {
        display: flex;
        flex-direction: column;
        align-items: center;
        width: 1200px;
        margin: 0 auto;
        min-height: calc(100vh - 258px);
        & .title {
            padding-top: 60px;
            box-sizing: border-box;
            font-size: 32px;
            font-weight: 500;
            color: #333;
        }
        & .txt {
            font-size: 20px;
            color: #333;
        }
        & button {
            display: flex;
            padding: 10px 20px;
            background-color: var(--red-color);
            border-radius: 40px;
            margin-top: 60px;
            font-size: 16px;
            font-weight: 500;
            color: #fff;
            cursor: pointer;
        }
    }
`;

const ProjectStartCreate = () => {
    const navigate = useNavigate();

    return (
        <StyledCreateStartDiv>
            <div className="inner">
                <span className="title">
                    간편하게 시작하는 프로젝트
                </span>
                <span className="txt">
                    당신의 아이디어가 필요합니다.
                </span>
                <button onClick={() => {navigate('/projectCreate/new')}}>지금 시작하기</button>
            </div>
        </StyledCreateStartDiv>
    );
};

export default ProjectStartCreate;