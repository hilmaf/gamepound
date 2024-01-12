import React from 'react';
import { Route, Routes, useNavigate } from 'react-router-dom';
import styled from 'styled-components';
import UserCreated from './UserCreated';
import UserBacked from './UserBacked';
import UserReview from './UserReview';
import ProfileMenu from '../../component/userpage/ProfileMenu';
import { useUserMemory } from '../../component/context/UserContext';

const SytledUserPageMainDiv = styled.div`
    width: 1200px;
    margin: 0 auto;
`;

const UserPageMain = () => {

    const navigate = useNavigate();

    const {loginMemberVo} = useUserMemory();

    if(loginMemberVo && sessionStorage.getItem("loginMemberVo")) {
        return (
            <SytledUserPageMainDiv>
                <ProfileMenu />
                <Routes>
                    <Route path='created' element={<UserCreated />}></Route>
                    <Route path='backed' element={<UserBacked />}></Route>
                    <Route path='review' element={<UserReview />}></Route>
                </Routes>
            </SytledUserPageMainDiv>
        );    
    } else {
        alert("로그인한 회원만 접근할 수 있는 페이지입니다.");
        navigate('/login');
    }

    
};

export default UserPageMain;