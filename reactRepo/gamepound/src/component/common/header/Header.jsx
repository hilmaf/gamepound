import React from 'react';
import logoImage from '../../../assets/images/logo.svg';
import searchIco from '../../../assets/images/ico/ico_search.svg';
import { Link } from 'react-router-dom';
import styled from 'styled-components';
import Nav from './nav/Nav';
import LoginArea from './LoginArea';
import { useHeaderMemory } from '../../context/HeaderContext';

const StyledHeaderDiv = styled.header`
    display: flex;
    position: sticky;
    top: 0;
    left: 0;
    width: 100%;
    flex-direction: column;
    align-items: center;
    width: 100%;
    box-shadow: 0 0 15px 3px rgba(0, 0, 0, .1);
    background-color: #fff;
    z-index: 9;

    &.payment {
        padding: 5px 0;
        & .paymentBtn {
            display: flex;
            font-size: 14px;
            background-color: #fff;
            cursor: pointer;
        }
        & .topArea {
            & .userArea {
                & > a {
                    display: none;
                }
            }
        }
        & .bottomArea {
            display: none;
        }
    }
    &.create {
        padding: 5px 0;
        & .createBtn {
            display: flex;
            align-items: center;
            font-size: 14px;
            background-color: #fff;
            cursor: pointer;
            &::before {
                content: "";
                display: block;
                width: 6px;
                height: 6px;
                border: 2px solid #333;
                border-width: 2px 0 0 2px;
                transform: rotate(-45deg);
                margin: 2px 10px 0 0;
            }
        }
        & .topArea {
            & .userArea {
                & > a {
                    display: none;
                }
            }
        }
        & .bottomArea {
            display: none;
        }
    }
    &.createMain {
        padding: 5px 0;
        & .createMainBtn {
            display: flex;
            align-items: center;
            font-size: 14px;
            background-color: #fff;
            cursor: pointer;
            &::before {
                content: "";
                display: block;
                width: 6px;
                height: 6px;
                border: 2px solid #333;
                border-width: 2px 0 0 2px;
                transform: rotate(-45deg);
                margin: 2px 10px 0 0;
            }
        }
        & .topArea {
            & h1 {
                display: none;
            }
            & .userArea {
                & > a {
                    display: none;
                }
                & .createMainStateBtn {
                    display: flex;
                    align-items: center;
                    font-size: 13px;
                    background-color: #fff;
                    border: 1px solid #ddd;
                    padding: 10px 15px;
                    border-radius: 5px;
                    cursor: pointer;
                    &:disabled {
                        background-color: #f5f5f5;
                        color: #999;
                        cursor: default;
                    }
                }
            }
        }
        & .bottomArea {
            display: none;
        }
    }

    & .inner {
        width: 1200px;
    }
    @media screen and (max-width: 1200px) {
        & .inner {
            width: 100%;
            box-sizing: border-box;
            padding: 0 20px;
        }
    }

    & .topArea {
        display: flex;
        justify-content: space-between;
        align-items: center;
        padding: 10px 0;
        box-sizing: border-box;

        & h1 a {
            display: flex;
            width: 195px;
            height: 35px;
            background: url(${logoImage}) no-repeat center;
            background-size: 100% auto;
        }
        & .userArea {
            display: flex;
            gap: 10px;
            align-items: center;
            & > a {
                display: flex;
                padding: 10px;
                font-size: 14px;
                font-weight: 500;
            }
        }
    }

    & .bottomArea {
        display: flex;
        justify-content: space-between;
        align-items: center;

        .searchArea {
            position: relative;
            & input {
                display: flex;
                padding: 10px 35px 10px 10px;
                width: 250px;
                box-sizing: border-box;
                border: 1px solid #ddd;
                border-radius: 5px;
                font-size: 13px;
                
                &:focus {
                    border: 1px solid #333;
                    outline: none;
                }
                &::placeholder {
                    color: #ccc;
                }
            }
            & button {
                display: flex;
                position: absolute;
                top: 50%;
                right: 10px;
                margin-top: -8px;
                background: url(${searchIco}) no-repeat center;
                width: 18px;
                height: 19px;
                text-indent: -9999px;
                cursor: pointer;
            }
            &.active {
                position: absolute;
                top: 0;
                left: 0;
                width: 100%;
                padding: 41px 30px;
                box-sizing: border-box;
                background-color: #fff;
                z-index: 11;
                & input {
                    width: 100%;
                    font-size: 20px;
                    padding-left: 30px;
                    box-sizing: border-box;
                }
                & button {
                    right: 40px;
                }
            }
        }
    }
`;

const handleSearchActive = (e) => {
    const searchArea = e.target.parentNode;
    searchArea.classList.add('active');
    
}
const handleSearchBlur = (e) => {
    const searchArea = e.target.parentNode;
    searchArea.classList.remove('active');
}

const Header = () => {

    const {pageType} = useHeaderMemory();

    return (
        <StyledHeaderDiv className={pageType}>
            <div className="inner">

                <div className='topArea'>

                    { // 후원 버튼
                        pageType === 'payment' ?  <button className='paymentBtn'>프로젝트 후원하기</button> : ''
                    }
                    { // 프로젝트 create 버튼
                        pageType === 'create' ?  <button className='createBtn'>내가 만든 프로젝트</button> : ''
                    }
                    { // createMain 버튼
                        pageType === 'createMain' ?  <button className='createMainBtn'></button> : ''
                    }

                    <h1><Link to='/'></Link></h1>
                    <div className='userArea'>
                        <Link to='/projectCreate/start' className='projectUploadBtn'>프로젝트 올리기</Link>
                        <Link to='' className=''>관심</Link>
                        <Link to='' className=''>알림</Link>
                        
                        { // createMain 버튼
                            pageType === 'createMain' ?  
                            <button className='createMainStateBtn' disabled>기획중 · 13% 완료</button> 
                            :
                            ''
                        }
                        <LoginArea />
                    </div>
                </div>

                <div className='bottomArea'>

                    <Nav />

                    <div className="searchArea">
                        <input type="text" onFocus={handleSearchActive} onBlur={handleSearchBlur} placeholder='검색어를 입력해주세요.' />
                        <button>검색</button>
                    </div>

                </div>

            </div>
        </StyledHeaderDiv>
    );
};

export default Header;