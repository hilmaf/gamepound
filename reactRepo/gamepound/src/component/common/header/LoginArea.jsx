import React from 'react';
import styled from 'styled-components';

const StyledLoginAreaDiv = styled.ul`
    display: flex;
    & li button {
        display: flex;
        align-items: center;
        justify-content: center;
        gap: 10px;
        padding: 10px 15px;
        border: 1px solid #ddd;
        border-radius: 5px;
        background-color: #fff;
        cursor: pointer;

        & span {
            display: flex;
            align-items: center;
            justify-content: center;
            overflow: hidden;
            width: 25px;
            height: 25px;
            border-radius: 50%;
            background-color: #ddd;
        }
        & strong {
            font-size: 13px;
            font-weight: 500;
        }
    }
`;

const LoginArea = () => {
    return (
        <StyledLoginAreaDiv>
            <li>
                <button>
                    <span></span>
                    <strong>로그인/회원가입</strong>
                </button>
            </li>
            <li>
                <button>
                    <span></span>
                    <strong>유저이름</strong>
                </button>
            </li>
        </StyledLoginAreaDiv>
    );
};

export default LoginArea;