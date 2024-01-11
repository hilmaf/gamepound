import React, { useEffect } from 'react';
import { useHeaderMemory } from '../../../component/context/HeaderContext';
import styled from 'styled-components';
import { NavLink, Route, Routes } from 'react-router-dom';
import ProjectBasicCreate from './ProjectBasicCreate';
import ProjectPlanCreate from './ProjectPlanCreate';
import ProjectRewardCreate from './ProjectRewardCreate';
import ProjectDateplanCreate from './ProjectDateplanCreate';
import ProjectUserinfoCreate from './ProjectUserinfoCreate';

const StyledCreateMainDiv = styled.div`
    padding-top: 184px;
    box-sizing: border-box;
    min-height: calc(100vh - 202px);
    background-color: #f5f5f5;
    & .createMainHeader {
        position: absolute;
        top: 72px;
        left: 0;
        width: 100%;
        background-color: #fff;
        padding: 40px 0;
        z-index: 9;
        & .inner {
            display: flex;
            align-items: center;
            flex-wrap: wrap;
            width: 1200px;
            margin: 0 auto;
            gap: 0 40px;
            & .img {
                display: block;
                width: 200px;
                height: 133px;
                background-color: #ddd;
                & img {
                    max-width: 100%;
                    min-width: 100%;
                    min-height: 100%;
                }
            }
            & .titleBox {
                & .title {
                    font-size: 32px;
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
        }
    }
    
    & .linkList {
        width: 1200px;
        margin: 0 auto;
        display: flex;
        justify-content: space-between;
        padding: 30px 0;
        gap: 10px;
        & > * {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            width: calc((100% / 5) - 40px);
            padding: 20px;
            box-sizing: border-box;
            background-color: #fff;
            border-radius: 5px;
            border: 1px solid transparent;
            font-size: 15px;
            font-weight: 500;
            color: #333;
            &:hover {
                border-color: #333;
            }
            & span {
                font-size: 13px;
                color: #999;
            }
        }
    }
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
                <div className="inner">
                    <span className="img"><img src="프로젝트이미지" alt="프로젝트이미지" /></span>
                    <div className="titleBox">
                        <div className="title">프로젝트 제목</div>
                        <div className="category">
                            <span>카테고리 대분류</span>
                            <span>카테고리 소분류</span>
                        </div>
                    </div>
                </div>
            </div>

            <div className="linkList">
                <NavLink to='../main/basic'>
                    기본정보
                    <span>12% 작성 완료</span>
                </NavLink>
                <NavLink to='../main/plan'>
                    펀딩 계획
                    <span>12% 작성 완료</span>
                </NavLink>
                <NavLink to='../main/reward'>
                    선물 구성
                    <span>12% 작성 완료</span>
                </NavLink>
                <NavLink to='../main/dateplan'>
                    프로젝트 계획
                    <span>12% 작성 완료</span>
                </NavLink>
                <NavLink to='../main/userinfo'>
                    창작자 정보
                    <span>12% 작성 완료</span>
                </NavLink>
            </div>
            <Routes>
                <Route path='../main/basic' element={<ProjectBasicCreate />} />
                <Route path='../main/plan' element={<ProjectPlanCreate />} />
                <Route path='../main/reward' element={<ProjectRewardCreate />} />
                <Route path='../main/dateplan' element={<ProjectDateplanCreate />} />
                <Route path='../main/userinfo' element={<ProjectUserinfoCreate />} />
            </Routes>
        </StyledCreateMainDiv>
        
    );
};

export default ProjectCreateMain;