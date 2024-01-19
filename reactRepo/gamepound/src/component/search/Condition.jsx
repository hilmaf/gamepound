import React, { useState } from 'react';
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
        background-color: #f5f5f5;
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

    const {conditionVo, setConditionVo} = useSearchContext();

    const handleSelectChange = (e) => {

        const {name, value} = e.target;

        setConditionVo({
            ...conditionVo,
            [name]: value
        });

        console.log(conditionVo);

        fetch("http://127.0.0.1:8889/gamepound/project/search", {
            method: "post",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(conditionVo)
        })
        .then(resp => resp.json())
        .then(data => {
            console.log(data);
        })
    }

    return (
        <StyledSearchConditionDiv>
            {
                window.location.pathname === '/search'
                ?
                <div className='query'>
                    <span>검색어 :</span>  "{query.query}"
                </div>
                :
                <></>
            }
            <select name='status' className='project_status' onChange={handleSelectChange}>
                <option value="all" selected>전체 프로젝트</option>
                <option value="ing">진행 중인 프로젝트</option>
                <option value="success">성사된 프로젝트</option>
                <option value="prelaunch">공개예정 프로젝트</option>
            </select>
            <select name='achievementRate' onChange={handleSelectChange}>
                <option value="all">달성률</option>
                <option value="under75">75% 이하</option>
                <option value="between">75% ~ 100%</option>
                <option value="over100">100% 이상</option>
            </select>
        </StyledSearchConditionDiv>
    );
};

export default Condition;