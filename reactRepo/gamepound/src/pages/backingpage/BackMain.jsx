import React from 'react';
import {styled} from 'styled-components';
import ProjectBriefInfo from '../../component/project/ProjectBriefInfo';
import BackingProcess from '../backingpage/BackingProcess';

const StyledBackMainDiv = styled.div`
    width: 1200px;
    display: flex;
    justify-content: start;
    align-items: center;
`;

const BackMain = () => {
    return (
        <StyledBackMainDiv>
            <ProjectBriefInfo />
            <BackingProcess />
        </StyledBackMainDiv>
    );
};

export default BackMain;