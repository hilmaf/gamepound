import React, { useState } from 'react';
import styled from 'styled-components';


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

    const [condition, setCondition] = useState([]);

    

    return (
        <StyledSearchConditionDiv>
            <div className='query'>
                <span>검색어 :</span>  "{query.query}"
            </div>
            <select className='project_status' value="">
                <option value="">전체 프로젝트</option>
                <option value="">진행 중인 프로젝트</option>
                <option value="">성사된 프로젝트</option>
                <option value="">공개예정 프로젝트</option>
            </select>
            <select className='achieveRate' value="">
                <option value="">75% 이하</option>
                <option value="">75% ~ 100%</option>
                <option value="">100% 이상</option>
            </select>
        </StyledSearchConditionDiv>
    );
};

export default Condition;