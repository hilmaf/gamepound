import React from 'react';
import styled from 'styled-components';
import ProjectBriefInfo from '../../component/project/ProjectBriefInfo';
import BackInfo from './BackInfo';
const StyledBackDetailDiv = styled.div`
`;

const BackDetail = () => {
    return (
        <StyledBackDetailDiv>
            <ProjectBriefInfo />
            <BackInfo />
        </StyledBackDetailDiv>
    );
};

export default BackDetail;