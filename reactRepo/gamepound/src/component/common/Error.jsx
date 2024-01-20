import React from 'react';
import { Link } from 'react-router-dom';
import styled from 'styled-components';

const StyledError = styled.div`
    display: flex;
    align-items: center;
    justify-content: center;
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100vh;
    background-color: #fff;
    z-index: 100;
    & .text-center {
        display: flex;
        flex-direction: column;
        align-items: center;
        & > a {
            display: block;
            padding: 5px 10px;
            border-radius: 5px;
            border: 1px solid #ddd;
            margin-top: 20px;
            &:hover,
            &:focus,
            &:active {
                background-color: var(--red-color);
                border-color: var(--red-color);
                color: #fff;
            }

        }
    }



    & .error {
        color: #5a5c69;
        font-size: 7rem;
        font-weight: 500;
        position: relative;
        line-height: 1;
        width: 12.5rem;
        &::before {
            content: attr(data-text);
            position: absolute;
            left: -2px;
            text-shadow: 1px 0 #4e73df;
            top: 0;
            color: #5a5c69;
            background: #f8f9fc;
            overflow: hidden;
            clip: rect(0,900px,0,0);
            animation: noise-anim-2 3s infinite linear alternate-reverse;
        }
        &::after {
            content: attr(data-text);
            position: absolute;
            left: 2px;
            text-shadow: -1px 0 #e74a3b;
            top: 0;
            color: #5a5c69;
            background: #f8f9fc;
            overflow: hidden;
            clip: rect(0,900px,0,0);
            animation: noise-anim 2s infinite linear alternate-reverse;
        }
    }
    @-webkit-keyframes noise-anim {
        0% {
            clip: rect(49px, 9999px, 40px, 0);
        }
        5% {
            clip: rect(75px, 9999px, 72px, 0);
        }
        10% {
            clip: rect(97px, 9999px, 93px, 0);
        }
        15% {
            clip: rect(15px, 9999px, 9px, 0);
        }
        20% {
            clip: rect(14px, 9999px, 92px, 0);
        }
        25% {
            clip: rect(18px, 9999px, 94px, 0);
        }
        30% {
            clip: rect(17px, 9999px, 20px, 0);
        }
        35% {
            clip: rect(71px, 9999px, 59px, 0);
        }
        40% {
            clip: rect(42px, 9999px, 84px, 0);
        }
        45% {
            clip: rect(56px, 9999px, 25px, 0);
        }
        50% {
            clip: rect(46px, 9999px, 14px, 0);
        }
        55% {
            clip: rect(47px, 9999px, 1px, 0);
        }
        60% {
            clip: rect(64px, 9999px, 58px, 0);
        }
        65% {
            clip: rect(89px, 9999px, 92px, 0);
        }
        70% {
            clip: rect(56px, 9999px, 39px, 0);
        }
        75% {
            clip: rect(80px, 9999px, 71px, 0);
        }
        80% {
            clip: rect(8px, 9999px, 13px, 0);
        }
        85% {
            clip: rect(66px, 9999px, 68px, 0);
        }
        90% {
            clip: rect(68px, 9999px, 4px, 0);
        }
        95% {
            clip: rect(56px, 9999px, 14px, 0);
        }
        100% {
            clip: rect(28px, 9999px, 53px, 0);
        }
    }
    @keyframes noise-anim {
        0% {
            clip: rect(49px, 9999px, 40px, 0);
        }
        5% {
            clip: rect(75px, 9999px, 72px, 0);
        }
        10% {
            clip: rect(97px, 9999px, 93px, 0);
        }
        15% {
            clip: rect(15px, 9999px, 9px, 0);
        }
        20% {
            clip: rect(14px, 9999px, 92px, 0);
        }
        25% {
            clip: rect(18px, 9999px, 94px, 0);
        }
        30% {
            clip: rect(17px, 9999px, 20px, 0);
        }
        35% {
            clip: rect(71px, 9999px, 59px, 0);
        }
        40% {
            clip: rect(42px, 9999px, 84px, 0);
        }
        45% {
            clip: rect(56px, 9999px, 25px, 0);
        }
        50% {
            clip: rect(46px, 9999px, 14px, 0);
        }
        55% {
            clip: rect(47px, 9999px, 1px, 0);
        }
        60% {
            clip: rect(64px, 9999px, 58px, 0);
        }
        65% {
            clip: rect(89px, 9999px, 92px, 0);
        }
        70% {
            clip: rect(56px, 9999px, 39px, 0);
        }
        75% {
            clip: rect(80px, 9999px, 71px, 0);
        }
        80% {
            clip: rect(8px, 9999px, 13px, 0);
        }
        85% {
            clip: rect(66px, 9999px, 68px, 0);
        }
        90% {
            clip: rect(68px, 9999px, 4px, 0);
        }
        95% {
            clip: rect(56px, 9999px, 14px, 0);
        }
        100% {
            clip: rect(28px, 9999px, 53px, 0);
        }
    }
    @-webkit-keyframes noise-anim-2 {
        0% {
            clip: rect(16px, 9999px, 10px, 0);
        }
        5% {
            clip: rect(22px, 9999px, 29px, 0);
        }
        10% {
            clip: rect(6px, 9999px, 68px, 0);
        }
        15% {
            clip: rect(85px, 9999px, 95px, 0);
        }
        20% {
            clip: rect(65px, 9999px, 91px, 0);
        }
        25% {
            clip: rect(93px, 9999px, 68px, 0);
        }
        30% {
            clip: rect(10px, 9999px, 27px, 0);
        }
        35% {
            clip: rect(37px, 9999px, 25px, 0);
        }
        40% {
            clip: rect(12px, 9999px, 23px, 0);
        }
        45% {
            clip: rect(40px, 9999px, 18px, 0);
        }
        50% {
            clip: rect(19px, 9999px, 71px, 0);
        }
        55% {
            clip: rect(2px, 9999px, 35px, 0);
        }
        60% {
            clip: rect(16px, 9999px, 69px, 0);
        }
        65% {
            clip: rect(8px, 9999px, 65px, 0);
        }
        70% {
            clip: rect(30px, 9999px, 57px, 0);
        }
        75% {
            clip: rect(14px, 9999px, 4px, 0);
        }
        80% {
            clip: rect(39px, 9999px, 30px, 0);
        }
        85% {
            clip: rect(22px, 9999px, 35px, 0);
        }
        90% {
            clip: rect(58px, 9999px, 71px, 0);
        }
        95% {
            clip: rect(34px, 9999px, 90px, 0);
        }
        100% {
            clip: rect(67px, 9999px, 68px, 0);
        }
    }
    @keyframes noise-anim-2 {
        0% {
            clip: rect(16px, 9999px, 10px, 0);
        }
        5% {
            clip: rect(22px, 9999px, 29px, 0);
        }
        10% {
            clip: rect(6px, 9999px, 68px, 0);
        }
        15% {
            clip: rect(85px, 9999px, 95px, 0);
        }
        20% {
            clip: rect(65px, 9999px, 91px, 0);
        }
        25% {
            clip: rect(93px, 9999px, 68px, 0);
        }
        30% {
            clip: rect(10px, 9999px, 27px, 0);
        }
        35% {
            clip: rect(37px, 9999px, 25px, 0);
        }
        40% {
            clip: rect(12px, 9999px, 23px, 0);
        }
        45% {
            clip: rect(40px, 9999px, 18px, 0);
        }
        50% {
            clip: rect(19px, 9999px, 71px, 0);
        }
        55% {
            clip: rect(2px, 9999px, 35px, 0);
        }
        60% {
            clip: rect(16px, 9999px, 69px, 0);
        }
        65% {
            clip: rect(8px, 9999px, 65px, 0);
        }
        70% {
            clip: rect(30px, 9999px, 57px, 0);
        }
        75% {
            clip: rect(14px, 9999px, 4px, 0);
        }
        80% {
            clip: rect(39px, 9999px, 30px, 0);
        }
        85% {
            clip: rect(22px, 9999px, 35px, 0);
        }
        90% {
            clip: rect(58px, 9999px, 71px, 0);
        }
        95% {
            clip: rect(34px, 9999px, 90px, 0);
        }
        100% {
            clip: rect(67px, 9999px, 68px, 0);
        }
    }
`;

const Error = () => {
    return (
        <StyledError>
            <div className="text-center">
                <div className="error" data-text="404">404</div>
                <p className="lead text-gray-800 mb-5">Page Not Found</p>
                <p className="text-gray-500 mb-0">페이지를 찾을 수 없습니다.</p>
                <Link to='/'>← 메인페이지로 돌아가기</Link>
            </div>
        </StyledError>
    );
};



export default Error;