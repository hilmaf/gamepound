import React from 'react';
import styled from 'styled-components';
import ProjectBriefInfo from '../../component/project/ProjectBriefInfo';
import BackInfo from './BackInfo';
import { useParams } from 'react-router-dom';
const StyledBackDetailDiv = styled.div`
`;

const BackDetail = () => {

    const {no} = useParams();
    console.log(no);

    return (
        <StyledBackDetailDiv>
            <ProjectBriefInfo />
            <BackInfo />
        </StyledBackDetailDiv>
    );
};

export default BackDetail;