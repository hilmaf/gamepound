import React from 'react';
import { useNavigate } from 'react-router-dom';
import styled from 'styled-components';

const StyledProjectBoxInfoDiv = styled.div`
    width: calc(100% / 4 - 30px);
    height: 410px;
    cursor: pointer;
    margin-right: 25px;

    & > img {
        width: 100%;
        height: 300px;
        background-size: cover;
        object-fit: cover;
        background-color: aliceblue;
    }

    & > .category {
        padding-top: 10px;
        font-size: 12px;
        
        & > span {
            opacity: 0.95;
            padding-right: 10px;
        }
    }

    & > .title {
        height: 30px;
        line-height: 30px;
        font-size: 16px;
        overflow: hidden;
        white-space: nowrap;
        text-overflow: ellipsis;
    }

    & > .progress {
        display: flex;
        justify-content: space-between;

        & > .achievement {

            & > #achievement_rate {
                font-size: 15px;
                font-weight: 900;
                padding-right: 5px;
            }

            & > #achievement_amnt {
                font-size: 12px;
            }
        }

        & > .status {
            font-size: 13px;
        }
    }
`;

const ProjectListBoxInfo = ({project}) => {
    
    const navigate = useNavigate();

    const handleBoxClick= () => {
        navigate("/project/detail/story/" + project.no);
    }

    return (
        <StyledProjectBoxInfoDiv onClick={handleBoxClick}>
            <img src={project.imageUrl} alt="프로젝트 대표 이미지"></img>
            <div className='category'>
                <span>{project.mainCategory} | {project.subCategory}</span>
                <span>{project.memberName}</span>
            </div>
            <div className='title' key={project.no}>
                {project.title}
            </div>
            <div className='progress'>
                <div className='achievement'>
                    <span id='achievement_rate'>{project.achievementRate}%</span>
                    <span id='achievement_amnt'>{project.currentAmount}원</span>
                </div>
                <div className='status'>
                    {project.statusName}
                </div>
            </div>
        </StyledProjectBoxInfoDiv>
    );
};

export default ProjectListBoxInfo;