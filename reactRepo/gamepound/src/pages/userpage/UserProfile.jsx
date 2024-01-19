import React, { useEffect, useState } from 'react';
import styled from 'styled-components';
import { useParams } from 'react-router-dom';

const StyledUserProfileDiv = styled.div`
    padding-left: 20px;

    & > div {
        height: 300px;
        display: flex;
        padding-top: 30px;
        font-size: 16px;
    }
`;

const UserProfile = () => {

    const {no} = useParams();

    const [profile, setProfile] = useState();

    useEffect(()=>{
        fetch("http://127.0.0.1:8889/gamepound/userpage?user=" + no)
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