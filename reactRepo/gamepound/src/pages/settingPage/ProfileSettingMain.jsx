import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import styled from 'styled-components';
import { useUserMemory } from '../../component/context/UserContext';
import NameSetting from './NameSetting';

const StyledAllDiv = styled.div`
    width: 100%;
`;
const StyledSettingsDiv = styled.div`
    width: 1200px;
    margin: 0 auto;
    padding: 20px;
    & > div:first-child{
        font-size: 30px;
        font-weight: 500;
        margin-bottom: 25px;
    }
    & > div:nth-child(2){
        & > div:first-child{
            font-size: 20px;
            font-weight: 500;
        }
        & > ul{
            & > li{
                border-bottom: 1px solid lightgray;
                padding: 20px 0px 20px 20px;
                & > div:first-child{
                    font-size: 18px;
                    font-weight: 500;
                }
            }
        }
    }
`;


const ProfileSettingMain = () => {

    //회원번호
    const {loginMemberVo} = useUserMemory();

    return (
        <StyledAllDiv>
            <StyledSettingsDiv>
                <div>
                    설정
                </div>
                <div>
                    <div>프로필/계정</div>
                    <ul>
                        <li>
                            <div>프로필 사진</div>
                            <div><img src='' alt="프로필 사진" /></div>
                            <div>
                                <button>저장</button>
                            </div>
                        </li>
                        <li>
                            <NameSetting loginMemberVo={loginMemberVo}/>
                        </li>
                        <li>
                            <div>소개</div>
                            <div><input type="text" value=''/></div>
                            <div>
                                <button>저장</button>
                            </div>
                        </li>
                        <li>
                            <div>웹사이트</div>
                            <div><input type="text" value=""/></div>
                            <div>
                                <button>저장</button>
                            </div>
                        </li>
                        <li>
                            <div>비밀번호</div>
                            <div>현재 비밀번호 : <input type="password" /></div>
                            <div>변경할 비밀번호 : <input type="password" /></div>
                            <div>
                                <button>저장</button>
                            </div>
                        </li>
                        <li>
                            <div>회원탈퇴</div>
                            <div>
                                <Link to='/quit'><button type="button">이동</button></Link>
                            </div>
                        </li>
                    </ul>
                </div>
            </StyledSettingsDiv>
        </StyledAllDiv>
    );
};

export default ProfileSettingMain;