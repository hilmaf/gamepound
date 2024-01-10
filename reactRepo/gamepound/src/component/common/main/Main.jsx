import React from 'react';
import styled from 'styled-components';
import { Route, Routes } from 'react-router-dom';
import ProjectMain from '../../../pages/projectpage/ProjectMain';
import UserPageMain from '../../../pages/userpage/UserPageMain';
import BackMain from '../../../pages/backingpage/BackMain';
import CreateMain from '../../../pages/projectpage/create/CreateMain';

const StyledMainDiv = styled.div`
    width: 100%;
    padding: 30px 0 50px;
`;

const Main = () => {
    return (
        <StyledMainDiv>
            <Routes>
                <Route path='/' element={<h1>메인페이지</h1>}></Route>
                <Route path='/project/*' element={<ProjectMain />}></Route>
                <Route path='/userpage/*' element={<UserPageMain />}></Route>
                <Route path='/back/*' element={<BackMain />}></Route>
                <Route path='/projectCreate/*' element={<CreateMain />}></Route>
            </Routes>
        </StyledMainDiv>
    );
};

export default Main;