import React from 'react';
import { NavLink } from 'react-router-dom';
import styled from 'styled-components';

const StyledProfileNavDiv = styled.div`
    width: 1200px;
    height: 56px;
    display: flex;
    margin-left: 20px;
    padding-top: 10px;

    & > a {
        width: 150px;
        font-size: 18px;
        cursor: pointer;
        display: flex;
        align-items: center;

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
            <NavLink to='/userpage/created'><span>올린 프로젝트</span></NavLink>
            <NavLink to='/userpage/backed'><span>후원한 프로젝트</span></NavLink>
            <NavLink to='/userpage/review'><span>프로젝트 후기</span></NavLink>
        </StyledProfileNavDiv>
    );
};

export default ProfileNav;