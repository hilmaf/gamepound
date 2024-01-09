import React, { useEffect, useState } from 'react';
import styled from 'styled-components';
import logoImage from '../../assets/images/logo_big.svg';
import { Link } from 'react-router-dom';
import InpText from './input/InpText';
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
            & > button {
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
            & .inpBtnGroup {
                display: flex;
                flex-direction: column;
                & label {
                    display: flex;
                    font-size: 13px;
                    padding: 3px 0;
                }
                & span {
                    display: flex;
                    justify-content: space-between;
                    & input {
                        display: flex;
                        width: calc(100% - 130px);
                        padding: 8px 15px;
                        font-size: 14px;
                        box-sizing: border-box;
                        border-radius: 5px;
                        border: 1px solid #ddd;
                        &::placeholder {
                            color: #999;
                        }
                        &:hover,
                        &:focus {
                            border-color: #333;
                            outline: none;
                        }
                    }
                    & button {
                        display: flex;
                        justify-content: center;
                        align-items: center;
                        width: 120px;
                        height: 40px;
                        border-radius: 5px;
                        background-color: #333;
                        font-size: 14px;
                        font-weight: 500;
                        color: #fff;
                        cursor: pointer;
                        &:disabled {
                            background-color: #ddd;
                            color: #aaa;
                            cursor: default;
                        }
                    }
                }
                & .msg {
                    font-size: 13px;
                    &.complete {
                        color: #4EB56B;
                    }
                    &.error {
                        color: #F05A5A;
                    }
                }
            }
            & .inpBtnGroup + .inpBtnGroup {
                margin-top: 5px;
            }
            & .pwdBox div + div {
                margin-top: 5px;
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

    const [formVo, setFormVo] = useState({});
    const [isValidEmail, setIsValidEmail] = useState(true);
    const [isSendEmail, setIsSendEmail] = useState(false);

    // 가입하기
    const handleJoin = (e) => {
        e.preventDefault();
        // 가입 버튼을 눌렀을 때 필요한 로직 추가
    }

    // 이메일 검사
    useEffect(() => {
        if (formVo.email) {
            // 이메일 정규식 검사
            const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
            const isValid = emailRegex.test(formVo.email);

            // 결과에 따라 메시지 업데이트
            setIsValidEmail(isValid);
        }
    }, [formVo.email]);

    // 인증메일 보내기
    const handleSendEmail = () => {
        if(formVo.email === ''){
            alert('빈값입ㄴ디ㅏ');
        }
        // fetch('', {

        // })
        // .then()
        // .then()
        // ;
        setIsSendEmail(true);
    }

    // formVo에 값 저장
    const handleEmailInputChange = (e) => {
        const { name, value } = e.target;
        setFormVo({
            ...formVo,
            [name]: value
        });
    };
    
    return (
        <StyledJoinPageDiv>
            <div className='wrap'>
                <div className='title'>
                    <h1>로고</h1>
                    <h2>이메일로 가입하기</h2>
                </div>
                <form onSubmit={handleJoin}>

                    <div className="emailBox">
                        <div className='inpBtnGroup'>
                            <label htmlFor="email">이메일 주소</label>
                            <span>
                                <input type="text" name="email" id="email" placeholder='이메일 주소를 입력해주세요.' onChange={handleEmailInputChange}/>
                                <button type='button' onClick={handleSendEmail} disabled={!isValidEmail}>인증메일 보내기</button>
                            </span>
                            <div className={`msg ${isValidEmail ? '' : 'error'}`}>{isValidEmail ? '' : '유효하지 않은 이메일 주소입니다.'}</div>
                        </div>
                        {
                            isSendEmail ? 
                            <div className='inpBtnGroup'>
                                <span>
                                    <input type="text" name="userCode" />
                                    <button type='button'>인증</button>
                                </span>
                                <div className='msg error'>인증에 성공하였습니다.</div>
                                <div className='msg complete'>인증에 실패하였습니다.</div>
                            </div>
                            :
                            ''
                        }
                    </div>

                    <div className="pwdBox">
                        <InpText name='pwd' text='비밀번호' label='비밀번호를 입력해주세요.' type='password'/>
                        <InpTextNon name='confirmPwd' text='비밀번호를 다시 입력해주세요.' type='password'/>
                    </div>

                    <button>가입하기</button>
                </form>
                <div className="otherLink">
                    <span>이미 게임파운드 계정이 있으신가요? <Link to='/login'>기존계정으로 로그인하기</Link></span>
                </div>
            </div>
        </StyledJoinPageDiv>
    );
};

export default JoinPage;