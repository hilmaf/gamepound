import React from 'react';
import styled from 'styled-components';

const StyledBackCompletedDiv = styled.div`
    height: 400px;
    font-size: 32px;
    display: flex; 
    flex-direction: column;
    align-items: center;
    margin-top: 100px;
`;

const BackCompleted = () => {
    return (
        <StyledBackCompletedDiv>
            <div>축하합니다. n번째</div>
            <div>공식후원자가 되셨습니다!</div>
        </StyledBackCompletedDiv>
    );
};

export default BackCompleted;