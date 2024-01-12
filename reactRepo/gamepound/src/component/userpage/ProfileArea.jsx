import React from 'react';
import styled from 'styled-components';
import { useUserMemory } from '../context/UserContext';

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

    const {loginMemberVo} = useUserMemory();

    return (
        <StyledProfileAreaDiv>
            <img src={loginMemberVo.pic} alt="Profile" />
            <div className='nick_area'>
                <div id='nick'>{loginMemberVo.name}</div>
                <button>계정 관리</button>
            </div>
        </StyledProfileAreaDiv>
    );    
    
};

export default ProfileArea;