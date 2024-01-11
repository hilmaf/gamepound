import React, { useEffect } from 'react';
import styled from 'styled-components';
import { NavLink, Route, Routes } from 'react-router-dom';
import ProjectBasicCreate from './ProjectBasicCreate';
import ProjectDateplanCreate from './ProjectDateplanCreate';
import ProjectRewardCreate from './ProjectRewardCreate';
import ProjectUserinfoCreate from './ProjectUserinfoCreate';
import ProjectPlanCreate from './ProjectPlanCreate';
import { useHeaderMemory } from '../../../component/context/HeaderContext';

const StyledCreateBasicIndexDiv = styled.div`
    padding-top: 124px;
    box-sizing: border-box;
    min-height: calc(100vh - 202px);
    background-color: #f5f5f5;
    & .createMainHeader {
        position: absolute;
        top: 72px;
        left: 0;
        width: 100%;
        background-color: #fff;
        z-index: 9;
        & .inner {
            display: flex;
            align-items: center;
            flex-wrap: wrap;
            width: 1200px;
            margin: 0 auto;
            gap: 0 40px;
            & .titleBox {
                width: 100%;
                & .title {
                    padding: 30px 0 20px;
                    font-size: 28px;
                    font-weight: 500;
                    color: #333;
                }
                & .category {
                    display: flex;
                    & * {
                        font-size: 14px;
                    }
                    & *:nth-child(1)::after {
                        content: "·";
                        margin: 0 5px;
                        color: #333;
                    }
                }
            }
            & .linkList {
                display: flex;
                gap: 10px;
                & * {
                    display: flex;
                    padding: 20px 10px;
                    border-bottom: 2px solid transparent;
                    font-size: 14px;
                    font-weight: 500;
                    color: #333;
                    &.active {
                        border-color: #333;
                    }
                }
            }
        }
    }
`;

const ProjectCreateMainIndex = () => {
    const { updatePageType } = useHeaderMemory();

    // header type
    useEffect(() => {
        updatePageType('createMain');
    }, [updatePageType]);

    return (
        <StyledCreateBasicIndexDiv>
            <div className="createMainHeader">
                <div className="inner">
                    <div className="titleBox">
                        <div className="title">프로젝트 제목</div>
                    </div>
                    <div className="linkList">
                        <NavLink to='basic'>기본정보</NavLink>
                        <NavLink to='plan'>펀딩 계획</NavLink>
                        <NavLink to='reward'>선물 구성</NavLink>
                        <NavLink to='dateplan'>프로젝트 계획</NavLink>
                        <NavLink to='userinfo'>창작자 정보</NavLink>
                    </div>
                </div>
            </div>
            <Routes>
                <Route path='basic' element={<ProjectBasicCreate />} />
                <Route path='plan' element={<ProjectPlanCreate />} />
                <Route path='reward' element={<ProjectRewardCreate />} />
                <Route path='dateplan' element={<ProjectDateplanCreate />} />
                <Route path='userinfo' element={<ProjectUserinfoCreate />} />
            </Routes>

        </StyledCreateBasicIndexDiv>
    );
};

export default ProjectCreateMainIndex;