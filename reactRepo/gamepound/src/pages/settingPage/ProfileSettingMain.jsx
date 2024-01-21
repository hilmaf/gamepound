import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import styled from 'styled-components';
import { useUserMemory } from '../../component/context/UserContext';

const StyledAllDiv = styled.div`
    width: 100%;
`;
const StyledStartDiv = styled.div`
    width: 1200px;
    margin: 0 auto;
    & > div{
        display: flex;
        flex-wrap: wrap;
        align-items: center;
        justify-content: center;
        height: 700px;
        & > div{
            & > div:first-child{
                display: flex;
                flex-direction: column;
                align-items: center;
                font-size: 20px;
                & > div > span{
                    color: red;
                }
            }
            & > div:nth-child(2){
                display: flex;
                align-items: center;
                margin-top: 20px;
                & > div:first-child{
                    width: 70px;
                }
                & > div:last-child{
                    margin-top: 5px;
                    font-size: 18px;
                    font-weight: 500;
                }
            }
            & > div:nth-child(3){
                display: flex;
                margin-top: 10px;
                align-items: center;
                & > div:first-child{
                    width: 70px;
                }
                & > input{
                    margin-top: 5px;
                    height: 40px;
                    width: 200px;
                    border: 1px solid #e0e0e0;
                    border-radius: 5px;
                    padding: 8px 0px 8px 10px;
                }
            }
            & > div:nth-child(4){
                display: flex;
                align-items: center;
                justify-content: center;
                margin-top: 10px;
                width: 100%;
                & > button{
                    width: 100%;
                    height: 40px;
                    font-size: 15px;
                    border-radius: 5px;
                    background-color: var(--red-color);
                    color: #ffffff;
                }
            }
        }
    }
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
                padding: 20px 0px 20px 0px;
                & > div:first-child{
                    font-size: 18px;
                    font-weight: 500;
                }
            }
        }
    }
`;


const ProfileSettingMain = () => {

    //스프링 기본 경로
    const baseURL = process.env.REACT_APP_API_URL;


    //회원번호
    const {loginMemberVo} = useUserMemory();

    //기초세팅
    const [profile, setProfile] = useState({
        "name" : "",
        "intro" : "",
        "siteUrl" : ""
    });
    const [changeValue, setChangeValue] = useState({});
    const [object, setObject] = useState({});
    const [start, setStart] = useState();
    const [checkPwd, setCheckPwd] = useState({});

    const handleCheckPwd = ()=>{
        const classCheckPwd = document.querySelector('.checkPwd')
        setCheckPwd({
            pwd : classCheckPwd.value
        });
        console.log(checkPwd);
        fetch(process.env.REACT_APP_API_URL + "/settings/checkPwd",{
            method: 'post',
            headers:{
                "Content-Type" : 'application/json'
            },
            body: JSON.stringify(checkPwd),
        })
        .then(resp=>resp.json())
        .then(data=>{
            if(data.msg === "good"){
                setStart(1);
            }
        })
    }

    useEffect(()=>{
        fetch(process.env.REACT_APP_API_URL + "/settings",{
            method: 'post',
            headers:{
                "Content-Type" : 'application/json'
            },
            body: JSON.stringify(loginMemberVo),
        })
        .then(resp=>resp.json())
        .then(data=>{
            setProfile(data);
        })
        .catch((e)=>console.log(e))
        ;
    }, [loginMemberVo])

    const handleChangeValue = (e) =>{
        console.log("e.target ::: ",e.target);
        console.log("e.target.name ::: ",e.target.name);
        setChangeValue({
            'name' : e.target.name,
            'value' : e.target.value,
        })
        setObject({
            [e.target.name] : e.target.value,
            no : profile.no
        })
        const {name, value} = e.target;
        setProfile({
            ...profile,
            [name] :value
        })
    }

    const handleSave = ()=>{
        console.log("changeValue ::: ",changeValue);
        console.log("object ::: ",object);
        if(object.no){
            fetch(baseURL + "/settings/" + changeValue.name,{
                method: 'post',
                headers:{
                    "Content-Type" : 'application/json'
                },
                body: JSON.stringify(object),
            })
            .then(resp=>resp.json())
            .then(data=>{
                console.log("ProfileSettingMain > handleSave ::: ",data);
                if(data.msg === "good"){
                    alert('변경 성공');
                }else{
                    alert('변경 실패');
                }
            })
            .catch(e=>console.log(e))
            .finally(()=>{
                setChangeValue({});
            })

        }
    }

    return (
        <StyledAllDiv>
            {
            start===undefined
            ?
            <StyledStartDiv>
                <div>
                    <div>
                        <div>
                            <div>정보를 안전하게 보호하기 위해</div>
                            <div><span>비밀번호를 다시 한 번 확인</span>합니다</div>
                        </div>
                        <div>
                            <div>아이디</div>
                            <div>{profile.name}</div>
                        </div>
                        <div>
                            <div>비밀번호</div>
                            <input type="password" placeholder='비밀번호를 입력해주세요.' className='checkPwd'/>
                        </div>
                        <div>
                            <button onClick={handleCheckPwd}>확인</button>
                        </div>
                    </div>
                </div>
            </StyledStartDiv>
            :
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
                            <div>이름</div>
                            <div><input type="text" value={profile.name} name='name' onChange={(e)=>{handleChangeValue(e)}}/></div>
                            <div>
                                <button onClick={handleSave}>저장</button>
                            </div>
                        </li>
                        <li>
                            <div>소개</div>
                            <div><input type="text" value={profile.intro} name='intro' onChange={(e)=>{handleChangeValue(e)}}/></div>
                            <div>
                                <button onClick={handleSave}>저장</button>
                            </div>
                        </li>
                        <li>
                            <div>웹사이트</div>
                            <div><input type="text" value={profile.siteUrl} name='siteUrl' onChange={(e)=>{handleChangeValue(e)}}/></div>
                            <div>
                                <button onClick={handleSave}>저장</button>
                            </div>
                        </li>
                        <li>
                            <div>비밀번호</div>
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
            }
        </StyledAllDiv>
    );
};

export default ProfileSettingMain;