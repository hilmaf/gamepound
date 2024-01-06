import React from 'react';
import {styled} from 'styled-components';
import ProjectBriefInfo from '../../component/project/ProjectBriefInfo';
import BackingForm from '../backingpage/BackingForm';

const StyledBackingFormDiv = styled.div`
    width: 1200px;
    display: flex;
    flex-direction: column;
    justify-content: start;
    align-items: center;
`;

const BackingProcess = () => {
    return (
        <StyledBackingFormDiv>
            <ProjectBriefInfo />
            <BackingForm />
        </StyledBackingFormDiv>
    );
};

export default BackingProcess;