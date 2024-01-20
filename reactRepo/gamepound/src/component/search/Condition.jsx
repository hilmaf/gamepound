import React, { useEffect, useState } from 'react';
import styled from 'styled-components';
import { useSearchContext } from '../context/SearchContext';


const StyledSearchConditionDiv = styled.div`
    width: 1200px;
    height: 80px;
    display: flex;
    align-items: center;
    
    & > .query {
        font-size: 16px;
        padding: 5px 10px;
        margin-right: 20px;
        font-weight: 900px;
        border: 1px solid var(--red-color);
        border-radius: 5px;

        & > span {
            margin-right: 5px
        }
    }
    
    & > .project_status {
        border: 1px solid #112155;
        border-radius: 5px;
        padding: 5px 10px;
        margin-right: 10px;
    }
    
    & > .achieveRate {
        background-color: #f5f5f5;
        padding: 5px 10px;
        margin-right: 10px;
    }
`;

const Condition = (query) => {

    const {conditionVo, setConditionVo, searchedVo, setSearchedVo} = useSearchContext();

    const handleSelectChange = (e) => {

        const {name, value} = e.target;

        setConditionVo({
            ...conditionVo,
            "query": sessionStorage.getItem('query'),
            [name]: value
        });


    }

    const statusSelectTag = document.querySelector(".project_status");


    return (
        <StyledSearchConditionDiv>
            {
                sessionStorage.getItem('query')
                ?
                <div className='query'>
                    <span>검색어 :</span>  "{sessionStorage.getItem('query')}"
                </div>
                :
                <></>
            }
            <select name='status' className='project_status' onChange={handleSelectChange}>
                <option value="all">전체 프로젝트</option>
                <option value="ing">진행 중인 프로젝트</option>
                <option value="success">성사된 프로젝트</option>
                <option value="prelaunch">공개예정 프로젝트</option>
            </select>
            {
                statusSelectTag.value === 'prelaunch'
                ?
                <></>
                :
                <select name='achievementRate' onChange={handleSelectChange}>
                    <option value="all">달성률</option>
                    <option value="under75">75% 이하</option>
                    <option value="between">75% ~ 100%</option>
                    <option value="over100">100% 이상</option>
                </select>
            }
        </StyledSearchConditionDiv>
    );
};

export default Condition;