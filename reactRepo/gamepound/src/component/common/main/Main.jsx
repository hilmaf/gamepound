import React from 'react';
import styled from 'styled-components';
import { Route, Routes } from 'react-router-dom';
import ProjectMain from '../../../pages/projectpage/ProjectMain';
import UserPageMain from '../../../pages/userpage/UserPageMain';
import BackMain from '../../../pages/backingpage/BackMain';

const StyledMainDiv = styled.div`
`;

const Main = () => {
    return (
        <StyledMainDiv>
            <Routes>
                <Route path='/' element={<h1>메인페이지</h1>}></Route>
                <Route path='/project/*' element={<ProjectMain />}></Route>
                <Route path='/userpage/*' element={<UserPageMain />}></Route>
                <Route path='/back/*' element={<BackMain />}></Route>
            </Routes>
        </StyledMainDiv>
    );
};

export default Main;