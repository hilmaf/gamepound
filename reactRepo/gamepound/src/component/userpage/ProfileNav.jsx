import React from 'react';
import { NavLink } from 'react-router-dom';
import styled from 'styled-components';

const StyledProfileNavDiv = styled.div`
    width: 1200px;
    height: 56px;
    display: flex;
    margin-left: 20px;
    padding-top: 10px;
    gap: 40px;

    & > a {
        font-size: 18px;
        cursor: pointer;
        display: flex;
        align-items: center;
        box-sizing: border-box;
        border-bottom: 2px solid transparent;

        &.active span {
            font-weight: 500;
            height: 56px;
            line-height: 56px;
            color: var(--black-color);
            border-bottom: 2px solid var(--red-color);
        }
    }
`;

const ProfileNav = () => {


    return (
        <StyledProfileNavDiv>
            <NavLink to='/userpage/'><span>프로필 소개</span></NavLink>
            <NavLink to='/userpage/created'><span>올린 프로젝트</span></NavLink>
            <NavLink to='/userpage/backed'><span>후원한 프로젝트</span></NavLink>
            <NavLink to='/userpage/review'><span>프로젝트 후기</span></NavLink>
        </StyledProfileNavDiv>
    );
};

export default ProfileNav;