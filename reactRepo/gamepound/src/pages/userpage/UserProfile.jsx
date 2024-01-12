import React, { useEffect, useState } from 'react';
import styled from 'styled-components';
import { useUserMemory } from '../../component/context/UserContext';

const StyledUserProfileDiv = styled.div`
    padding-left: 20px;

    & > div {
        height: 300px;
        display: flex;
        align-items: center;
        font-size: 20px;
    }
`;

const UserProfile = () => {

    const {loginMemberVo} = useUserMemory();
    const [profile, setProfile] = useState();

    useEffect(()=>{
        fetch("http://127.0.0.1:8889/gamepound/userpage?user=" + loginMemberVo.no)
        .then(resp => resp.text())
        .then(data => {
            console.log(data);
            setProfile(data);
        })
    }, [])

    return (
        <StyledUserProfileDiv>
            <div>{profile}</div>
        </StyledUserProfileDiv>
    );
};

export default UserProfile;