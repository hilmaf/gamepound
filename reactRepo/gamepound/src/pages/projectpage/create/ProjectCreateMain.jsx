import React, { useEffect } from 'react';
import { useHeaderMemory } from '../../../component/context/HeaderContext';
import { NavLink, Route, Routes } from 'react-router-dom';
import ProjectBasicCreate from './ProjectBasicCreate';
import ProjectPlanCreate from './ProjectPlanCreate';
import ProjectRewardCreate from './ProjectRewardCreate';
import ProjectDateplanCreate from './ProjectDateplanCreate';
import ProjectUserinfoCreate from './ProjectUserinfoCreate';
import styled from 'styled-components';

const StyledCreateMainDiv = styled.div`
    width: 1200px;
    margin: 0 auto;
`;

const ProjectCreateMain = () => {

    const { updatePageType } = useHeaderMemory();

    // header type
    useEffect(() => {
        updatePageType('createMain');
    }, [updatePageType]);

    return (
        <StyledCreateMainDiv>

            <div className="createMainHeader">
                <span className="img"><img src="프로젝트이미지" alt="" /></span>
                <div className="titleBox">
                    <div className="title">프로젝트 제목</div>
                    <div className="category">
                        <span>카테고리 대분류</span>
                        <span>카테고리 소분류</span>
                    </div>
                </div>

                <NavLink to='basic'>기본정보</NavLink>
                <NavLink to='plan'>펀딩 계획</NavLink>
                <NavLink to='reward'>선물 구성</NavLink>
                <NavLink to='dateplan'>프로젝트 계획</NavLink>
                <NavLink to='userinfo'>창작자 정보</NavLink>
            </div>
            <Routes>
                <Route path='basic' element={<ProjectBasicCreate />}></Route>
                <Route path='plan' element={<ProjectPlanCreate />}></Route>
                <Route path='reward' element={<ProjectRewardCreate />}></Route>
                <Route path='dateplan' element={<ProjectDateplanCreate />}></Route>
                <Route path='userinfo' element={<ProjectUserinfoCreate />}></Route>
            </Routes>
        </StyledCreateMainDiv>
    );
};

export default ProjectCreateMain;