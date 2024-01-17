import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import styled from 'styled-components';
import InpText from '../memberPage/input/InpText';
import InpTextNon from '../memberPage/input/InpTextNon';
import { useUserMemory } from '../../component/context/UserContext';

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

    //회원번호
    const {loginMemberVo} = useUserMemory();
    console.log(loginMemberVo);

    const [profile, setProfile] = useState({});
    const [memberName, setMemberName] = useState({});
    // const [img, setImg] = useState({});
    // const [intro, setIntro] = useState({});
    // const [siteUtl, setSiteUrl] = useState({});

    useEffect(()=>{
        fetch("http://localhost:8889/gamepound/settings",{
            method: 'post',
            headers: {
                "Content-Type": 'application/json'
            },
            body: JSON.stringify(loginMemberVo),
        })
        .then((resp)=>{return resp.json()})
        .then((data)=>{
            setProfile(data);
            setMemberName({
                "name" : data.name
            })
            console.log("ProfilSetting > fetch > 처음 정보 가져오기");
        })
        .catch((e)=>{console.log("오류 : " , e);})
        ;
    }, []);

    //input에 수정할 이름 입력
    const handleName = (e) =>{
        setMemberName(e.target.value);
        const {name, value} = e.target;
        setProfile({
            ...profile,
            [name] : value
        })
    }
    const handleNameSave = ()=>{
        fetch("http://127.0.0.1:8889/gamepound/settings/name",{
            method: "post",
            headers: {
                "Content-Type": 'application/json'
            },
            body: JSON.stringify(memberName),
        })
        .then(resp=>resp.json())
        .then(data=>{
            console.log(data);
        })
        .catch((e)=>{console.log("handleNameSave 오류 ::: " , e);})
    }




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
                            <div><img src={profile.pic ||""} alt="프로필 사진" /></div>
                            <div>
                                <button>저장</button>
                            </div>
                        </li>
                        <li>
                            <div>이름</div>
                            <div><input type="text" name='name' value={profile.name} onChange={(e)=>{handleName(e)}}/></div>
                            <div>
                                <button onClick={handleNameSave}>저장</button>
                            </div>
                        </li>
                        <li>
                            <div>소개</div>
                            <div><input type="text" value={profile.intro || ""}/></div>
                            <div>
                                <button>저장</button>
                            </div>
                        </li>
                        <li>
                            <div>웹사이트</div>
                            <div><input type="text" value={profile.siteUrl || ""}/></div>
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

export default ProfileSetting;