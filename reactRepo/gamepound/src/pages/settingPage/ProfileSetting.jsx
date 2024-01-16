import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import styled from 'styled-components';

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
                padding: 15px 0px 15px 20px;
            }
        }
    }
`;


const ProfileSetting = () => {

    // //회원번호
    // const [no, setNo] = useState([1]);

    // // const [profile, setProfile] = useState([]);
    // // const [img, setImg] = useState([]);
    // // const [name, setName] = useState([]);
    // // const [intro, setIntro] = useState([]);
    // // const [siteUtl, setSiteUrl] = useState([]);

    // useEffect(()=>{
    //     fetch("http://localhost:8889/settings",{
    //         method: 'post',
    //         headers: {
    //             'Content-Type': 'application/json'
    //         },
    //         body: JSON.stringify(no),
    //     })
    //     .then((resp)=>{return resp.json()})
    //     .then((data)=>{
    //         // setProfile(data);
    //     })
    //     .catch((e)=>{console.log("오류 : " + e);})
    //     ;
    // }, []);





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
                            <div><img src="" alt="프로필 사진" /></div>
                            <div>
                                <button>저장</button>
                            </div>
                        </li>
                        <li>
                            <div>이름</div>
                            <div>값</div>
                            <div>
                                <button>저장</button>
                            </div>
                        </li>
                        <li>
                            <div>소개</div>
                            <div>값</div>
                            <div>
                                <button>저장</button>
                            </div>
                        </li>
                        <li>
                            <div>웹사이트</div>
                            <div>값</div>
                            <div>
                                <button>저장</button>
                            </div>
                        </li>
                        <li>
                            <div>비밀번호</div>
                            <div>현재 비밀번호</div>
                            <div>변경할 비밀번호</div>
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

export default ProfileSetting;