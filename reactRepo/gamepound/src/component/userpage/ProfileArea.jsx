import React, { useEffect, useState } from 'react';
import styled from 'styled-components';
import { useUserMemory } from '../context/UserContext';
import { useParams } from 'react-router-dom';

const StyledProfileAreaDiv = styled.div`
    width: 1200px;
    height: 80px;
    display: flex;
    align-items: center;
    padding-top: 10px;
    padding-left: 30px;
    padding-bottom: 20px;

    & > img {
        width: 80px;
        height: 80px;
        border-radius: 80px;
        object-fit: cover;
    } 

    & > .nick_area {
        padding-left: 20px;

        & > #nick {
            font-size: 20px;
        }

        & > button {
            background-color: var(--red-color);
            padding: 5px 8px;
            margin-top: 8px;
            cursor: pointer;
        }
    }
`;

const ProfileArea = () => {

    const {no} = useParams();
    const [profileVo, setProfileVo] = useState();

    useEffect(()=> {
        fetch("http://127.0.0.1:8889/gamepound/userpage/profile?memberNo="+no)
        .then(resp => resp.json())
        .then(data => {
            setProfileVo(data);
            console.log(data);
        })
    }, [])

    const {loginMemberVo} = useUserMemory();

    return (
        <StyledProfileAreaDiv>
            {
                profileVo !== undefined && profileVo !== null
                ?
                <>
                <img src={profileVo.pic} alt="Profile" />
                <div className='nick_area'>
                    <div id='nick'>{profileVo.name}</div>
                    <button>계정 관리</button>
                </div>
                </>
                :
                <></>
            }
        </StyledProfileAreaDiv>
    );    
    
};

export default ProfileArea;