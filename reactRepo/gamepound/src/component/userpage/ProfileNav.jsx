import React from 'react';
import { NavLink, useNavigate } from 'react-router-dom';
import styled from 'styled-components';

const StyledProfileNavDiv = styled.div`
    width: 1200px;
    height: 56px;
    display: flex;
    padding-left: 20px;
    padding-top: 10px;

    & > a {
        width: 150px;
        font-size: 18px;
        cursor: pointer;
        display: flex;
        align-items: center;

        &.active span {
            display: block;
            padding: 15px;
            font-weight: 500;
            border-bottom: 2px solid #F05A5A;
        }
    }
`;

const ProfileNav = () => {

    return (
        <StyledProfileNavDiv>
            <NavLink to='/userpage/created'><span>올린 프로젝트</span></NavLink>
            <NavLink to='/userpage/backed'><span>후원한 프로젝트</span></NavLink>
            <NavLink to='/userpage/review'><span>프로젝트 후기</span></NavLink>
        </StyledProfileNavDiv>
    );
};

export default ProfileNav;