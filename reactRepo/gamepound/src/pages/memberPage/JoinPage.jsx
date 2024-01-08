import React from 'react';
import styled from 'styled-components';
import logoImage from '../../assets/images/logo_big.svg';
import InpText from './input/InpText';
import { Link } from 'react-router-dom';
import InpTextNon from './input/InpTextNon';

const StyledJoinPageDiv = styled.div`
    display: flex;
    align-items: center;
    justify-content: center;
    height: 100vh;
    background-color: #f5f5f5;

    & .wrap {
        display: flex;
        flex-direction: column;
        width: 400px;
        
        & form {
            display: flex;
            flex-direction: column;
            gap: 5px;
            & button {
                display: flex;
                justify-content: center;
                align-items: center;
                width: 100%;
                height: 50px;
                border-radius: 5px;
                background-color: #FF914D;
                font-size: 16px;
                font-weight: 500;
                color: #fff;
                cursor: pointer;
                margin-top: 40px;
            }
            & div + div label {
                margin-top: 10px;
            }
        }
        & .title {
            display: flex;
            flex-direction: column;
            align-items: center;
            margin-bottom: 40px;
            & h1 {
                background: url(${logoImage}) no-repeat center;
                text-indent: -9999em;
                width: 195px;
                height: 71px;
                padding: 20px;
            }
            & h2 {
                font-size: 20px;
                font-weight: 500;
                margin-top: 20px;
            }
        }
        & .otherLink {
            display: flex;
            flex-direction: column;
            font-size: 13px;
            color: #666;
            margin-top: 20px;
            & span a {
                color: #FF914D;
                margin-left: 5px;
                &:hover {
                    text-decoration: underline;
                }
            }
        }
    }

`;

const JoinPage = () => {

    const handleJoin = (e) => {
        e.preventDefault();
    }

    return (
        <StyledJoinPageDiv>
            <div className='wrap'>
                <div className='title'>
                    <h1>로고</h1>
                    <h2>이메일로 가입하기</h2>
                </div>
                <form onSubmit={handleJoin}>
                    <InpText name='email' text='이메일 주소' type='text' />
                    <InpTextNon name='email2' type='text' />
                    <InpText name='password' text='비밀번호' type='password' />
                    <button>회원가입</button>
                </form>
                <div className="otherLink">
                    <span>이미 게임파운드 계정이 있으신가요? <Link to='/login'>기존계정으로 로그인하기</Link></span>
                </div>
            </div>
        </StyledJoinPageDiv>
    );
};

export default JoinPage;