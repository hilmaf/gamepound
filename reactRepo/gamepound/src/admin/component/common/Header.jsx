import React from 'react';
import { Button } from 'react-bootstrap';
import styled from 'styled-components';

const StyledHeader = styled.header`
    display: flex;
    position: sticky;
    top: 0;
    left: 0;
    background-color: #fff;
    justify-content: flex-end;
    align-items: center;
    gap: 20px;
    box-shadow: 0 .15rem 1.75rem 0 rgba(58,59,69,.15);
    padding: 10px 20px;
    box-sizing: border-box;
    z-index: 10;
    & .txt {
        display: flex;
        font-size: 14px;
        & span {
            font-weight: 600;
            margin-right: 3px;
        }
    }
    & button {
        font-size: 13px;
    }
`;

const Header = () => {
    return (
        <StyledHeader>
            <div className="txt">
                <span>관리자</span>님 환영합니다.
            </div>
            <Button variant="secondary">로그아웃</Button>
        </StyledHeader>
    );
};

export default Header;