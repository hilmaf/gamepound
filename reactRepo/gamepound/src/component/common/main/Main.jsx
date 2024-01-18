import React from 'react';
import styled from 'styled-components';
import { Route, Routes, useNavigate } from 'react-router-dom';
import UserPageMain from '../../../pages/userpage/UserPageMain';
import BackMain from '../../../pages/backingpage/BackMain';
import CreateMain from '../../../pages/projectpage/create/CreateMain';
import { useUserMemory } from '../../context/UserContext';
import ProjectMain from '../../../pages/projectpage/ProjectMain';
import ProfileSetting from '../../../pages/settingPage/ProfileSetting';

const StyledMainDiv = styled.div`
    width: 100%;
    padding: 30px 0 50px;
`;

const Main = () => {

    const navigate = useNavigate();

    const userVo = useUserMemory();

    return (
        <StyledMainDiv>
            <Routes>
                <Route path='/' element={
                <h1>메인페이지</h1>
                }></Route>
                <Route path='/project/*' element={<ProjectMain/>}></Route>
                <Route path='/userpage/*' element={<UserPageMain />}></Route>
                <Route path='/back/*' element={<BackMain />}></Route>
                <Route path='/projectCreate/*' element={<CreateMain />}></Route>
                <Route path='/settings' element={<ProfileSetting/>}/>
            </Routes>
        </StyledMainDiv>
    );
};

export default Main;