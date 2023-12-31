import React, { useState } from 'react';
import styled from 'styled-components';
import InpText from './input/InpText';
import { Link, useNavigate } from 'react-router-dom';
import logoImage from '../../assets/images/logo_big.svg';
import { useUserMemory } from '../../component/context/UserContext';

const StyledLoginPageDiv = styled.div`
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
            gap: 10px;
            & button {
                display: flex;
                justify-content: center;
                align-items: center;
                width: 100%;
                height: 50px;
                border-radius: 5px;
                background-color: var(--red-color);
                font-size: 16px;
                font-weight: 500;
                color: #fff;
                cursor: pointer;
                margin-top: 40px;
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
                color: var(--red-color);
                margin-left: 5px;
                &:hover {
                    text-decoration: underline;
                }
            }
        }
    }

`;

const LoginPage = () => {

    const [formVo, setFormVo] = useState({});
    const {setLoginMemberVo} = useUserMemory();
    const navigate = useNavigate();


    const handleInputChange = (e) => {
        const {name, value} = e.target;
        setFormVo({
            ...formVo,
            [name]: value
        });
    }

    const handleLogin = (e) => {
        e.preventDefault();
        fetch('http://localhost:8889/gamepound/login', {
            method: 'post',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(formVo),
        })
        .then(resp => resp.json())
        .then((data) => {
            console.log();
            if(data.msg === 'good'){
                sessionStorage.setItem("loginMemberVo" , JSON.stringify(data.loginMember));
                setLoginMemberVo(sessionStorage.getItem('loginMemberVo'));
                navigate('/')
            } else {
                alert('로그인에 실패했습니다.');
            }
        })
        .catch(error => {
            console.error('Error during login:', error);
        });
        ;
    }

    return (
        <StyledLoginPageDiv>
            <div className='wrap'>
                <div className='title'>
                    <h1>로고</h1>
                    <h2>이메일로 로그인</h2>
                </div>
                <form onSubmit={handleLogin}>
                    <InpText name='email' text='이메일 주소' type='text' label='이메일 주소를 입력해주세요.' onChange={handleInputChange}/>
                    <InpText name='pwd' text='비밀번호' type='password' label='비밀번호를 입력해주세요.' onChange={handleInputChange} />
                    <button>로그인</button>
                </form>
                <div className="otherLink">
                    <span>아직 게임파운드 계정이 없으신가요? <Link to='/join'>회원가입</Link></span>
                    <span>혹시 비밀번호를 잊으셨나요? <Link to='/pwd'>비밀번호 재설정</Link></span>
                </div>
            </div>
        </StyledLoginPageDiv>
    );
};

export default LoginPage;