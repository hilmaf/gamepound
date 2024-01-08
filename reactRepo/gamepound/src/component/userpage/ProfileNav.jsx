import React from 'react';
import { NavLink, useNavigate } from 'react-router-dom';
import styled from 'styled-components';

const StyledProfileNavDiv = styled.div`
    width: 1200px;
    height: 56px;
    display: flex;
    padding-left: 20px;
    padding-top: 10px;

    & > div {
        width: 150px;
        font-size: 18px;
        cursor: pointer;
        display: flex;
        align-items: center;
    }
`;

const ProfileNav = () => {

    const navigate = useNavigate();

    return (
        <StyledProfileNavDiv>
            <div onClick={() => {navigate('/userpage/created')}}>올린 프로젝트</div>
            <div onClick={() => {navigate('/userpage/backed')}}>후원한 프로젝트</div>
            <div onClick={() => {navigate('/userpage/review')}}>프로젝트 후기</div>
        </StyledProfileNavDiv>
    );
};

export default ProfileNav;