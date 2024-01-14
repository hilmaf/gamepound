import React from 'react';
import styled from 'styled-components';


const StyledSearchConditionDiv = styled.div`
    width: 1200px;
    height: 80px;
    display: flex;
    
`;

const Condition = () => {
    return (
        <StyledSearchConditionDiv>
            <div className='query'>
                스타듀밸리
            </div>
            <select className='project_status'>
                <option>전체 프로젝트</option>
                <option>진행 중인 프로젝트</option>
                <option>성사된 프로젝트</option>
                <option>공개예정 프로젝트</option>
            </select>
            <select className='achieveRate'>
                <option>75% 이하</option>
                <option>75% ~ 100%</option>
                <option>100% 이상</option>
            </select>
        </StyledSearchConditionDiv>
    );
};

export default Condition;