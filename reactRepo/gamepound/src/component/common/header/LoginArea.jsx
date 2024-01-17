import React from 'react';
import { Link, useNavigate } from 'react-router-dom';
import styled from 'styled-components';
import { useUserMemory } from '../../context/UserContext';

const StyledLoginAreaDiv = styled.ul`
    display: flex;
    & li {
        position: relative;
        & > button {
            display: flex;
            align-items: center;
            justify-content: center;
            gap: 10px;
            padding: 7px 15px;
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

        & .userInfoMenu {
            display: none;
            position: absolute;
            top: 45px;
            right: 0;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            width: 150px;
            box-shadow: 0px 0px 12px 2px rgba(0, 0, 0, .1);
            & ul {
                display: flex;
                flex-direction: column;
                margin-bottom: 8px;
                padding-bottom: 8px;
                border-bottom: 1px solid #ddd;
                &:last-child {
                    margin-bottom: 0;
                    padding-bottom: 0;
                    border-bottom: 0;
                }
                & li * {
                    display: flex;
                    justify-content: flex-start;
                    box-sizing: border-box;
                    width: 100%;
                    padding: 8px 10px;
                    border-radius: 5px;
                    font-size: 14px;
                    transition: .2s;
                    border: none;
                    &:hover {
                        background-color: #f5f5f5;
                    }
                }
            }
        }
        &.userInfo.active .userInfoMenu {
            display: block;
            z-index: 10;
        }
    }
`;

const LoginArea = () => {

    const navigate = useNavigate();
    const {loginMemberVo, setLoginMemberVo} = useUserMemory();

    const handleUserInfo = (e) => {
        const target = e.currentTarget;
        target.parentNode.classList.toggle('active');
    }

    const handleLogout = (e) => {
        sessionStorage.removeItem('loginMemberVo');
        setLoginMemberVo(null);
    }

    return (
        <StyledLoginAreaDiv>
            {loginMemberVo === undefined || loginMemberVo === null ?
                (
                <li>
                    <button onClick={() => {
                        navigate('/login');
                    }}>
                        <span></span>
                        <strong>로그인/회원가입</strong>
                    </button>
                </li>
            ) : (
                <li className='userInfo'>
                    <button onClick={handleUserInfo}>
                        <span><img src={loginMemberVo.pic} alt='유저이미지' /></span>
                        <strong>{loginMemberVo.name}</strong>
                    </button>
                    <div className="userInfoMenu">
                        <ul>
                            <li><Link to='/'>프로필</Link></li>
                        </ul>
                        <ul>
                            <li><Link to='/userpage/backed'>후원한 프로젝트</Link></li>
                            <li><Link to='/'>관심 프로젝트</Link></li>
                        </ul>
                        <ul>
                            <li><Link to='/userpage/created'>내가 만든 프로젝트</Link></li>
                            <li><Link to='/settings'>설정</Link></li>
                            <li><button onClick={handleLogout}>로그아웃</button></li>
                        </ul>
                    </div>
                </li>
            )}
            
            
        </StyledLoginAreaDiv>
    );
};

export default LoginArea;