import React from 'react';
import { Route, Routes } from 'react-router-dom';
import styled from 'styled-components';
import UserCreated from './UserCreated';
import UserBacked from './UserBacked';
import UserReview from './UserReview';

const SytledUserPageMainDiv = styled.div`
    width: 1200px;
    background-color: aliceblue;
`;

const UserPageMain = () => {
    return (
        <SytledUserPageMainDiv>
            <Routes>
                <Route path='created' element={<UserCreated />}></Route>
                <Route path='backed' element={<UserBacked />}></Route>
                <Route path='review' element={<UserReview />}></Route>
            </Routes>
        </SytledUserPageMainDiv>
    );
};

export default UserPageMain;