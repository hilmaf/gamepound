import React from 'react';
import { useNavigate } from 'react-router-dom';
import styled from 'styled-components';

const StyledProjectBoxInfoDiv = styled.div`
    width: calc(100% / ${no => no.no} - 30px);
    height: ${props => props.no === 3 ? '410px' : '370px'};
    cursor: pointer;
    margin-right: 25px;
    color: var(--black-color);

    & > img {
        width: 100%;
        height: 205px;
        object-fit: cover;
    }

    & > .category {
        padding-top: 10px;
        font-size: 12px;
        
        & > span {
            opacity: 0.95;
            padding-right: 10px;
        }
    }

    & > .creator {
        padding-top: 5px;
        padding-bottom: 5px;
        font-size: 13px;
        color: rgba(0, 0, 0, 0.5);
    }

    & > .title {
        width: 100%;
        height: 40px;
        line-height: 30px;
        font-size: 16px;
        overflow: hidden;
        line-height: 20px;
        display: -webkit-box;
        text-overflow: ellipsis;
        -webkit-line-clamp: 2;
        -webkit-box-orient: vertical;
        margin-bottom: 10px;
        /* padding-top: 5px;
        height: 50px;
        font-size: 16px; */
        /* letter-spacing: 0.01px; */
    }

    & > .progress {
        display: flex;
        justify-content: space-between;

        & > .achievement {

            & > #achievement_rate {
                font-size: 16px;
                font-weight: 600;
                padding-right: 5px;
                color: var(--red-color);
            }

            & > #achievement_amnt {
                font-size: 16px;
            }
        }

        & > .status {
            font-size: 13px;
        }
    }
`;

const ProjectBoxInfo = ({no, project}) => {

    const navigate = useNavigate();

    const handleBoxClick= () => {
        navigate("/project/detail/story/" + project.projectNo);
    }

    return (
        <StyledProjectBoxInfoDiv no={no}>
            <img src={project.projectImg ? project.projectImg : ""} onClick={handleBoxClick} ></img>
            <div className='category'>
                <span>{project.categoryName} | {project.subCategoryName}</span>
            </div>
            <div className='creator'>
                <span>{project.memberName}</span>
            </div>
            <div className='title' onClick={handleBoxClick} key={project.projectNo}>
                {project.projectTitle}
            </div>
            <div className='progress'>
                <div className='achievement'>
                    <span id='achievement_rate'>{project.achievementRate}%</span>
                    <span id='achievement_amnt'>{project.currentAmount}원</span>
                </div>
                <div className='status'>
                    {project.projectStatus}
                </div>
            </div>
        </StyledProjectBoxInfoDiv>
    );
};

export default ProjectBoxInfo;