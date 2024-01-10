import React, { useEffect, useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import styled from 'styled-components';
import logoImage from '../../assets/images/logo_big.svg';
import InpText from './input/InpText';
import { useUserMemory } from '../../component/context/UserContext';

const StyledQuitDiv = styled.div`
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
    }
`;

const QuitPage = () => {

    const [formVo, setFormVo] = useState({});
    const navigate = useNavigate();
    const {loginMemberVo} = useUserMemory(); // 로그인 유저정보

    // 탈퇴처리
    const handleQuit = (e) => {
        e.preventDefault();
        const userConfirmed = window.confirm('정말 탈퇴하시겠어요?');

        if (userConfirmed) {
            fetch('http://localhost:8889/gamepound/quit', {
                method: 'post',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(formVo),
            })
            .then(resp => resp.json())
            .then(data => {
                if(data === 'good'){
                    alert('정상적으로 탈퇴가 되었습니다.');
                    navigate('/');
                } else {
                    alert('알 수 없는 이유로 탈퇴 처리가 완료되지 않았습니다.');
                }
            })
            ;
        } 
    }

    // 로그인정보 체크
    useEffect(() => {
        console.log(loginMemberVo);
        
    }, [loginMemberVo]);

    // FormVo 저장
    const handleInputChange = (e) => {
        const {name, value} = e.target;
        setFormVo({
            ...formVo,
            [name]: value
        });
    }

    return (
        <StyledQuitDiv>
            <div className='wrap'>
                <div className='title'>
                    <Link to='/'><h1>로고</h1></Link>
                    <h2>회원탈퇴</h2>
                </div>
                <form onSubmit={handleQuit}>
                    <InpText name='pwd' text='비밀번호' type='password' label='비밀번호를 입력해주세요.' onChange={handleInputChange} />
                    <button>회원탈퇴</button>
                </form>
            </div>
        </StyledQuitDiv>
    );
};

export default QuitPage;