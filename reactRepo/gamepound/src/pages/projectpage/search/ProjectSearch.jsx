import React, { useEffect } from 'react';
import styled from 'styled-components';
import Condition from '../../../component/search/Condition';

const StyledProjectSearchDiv = styled.div`
`;

const ProjectSearch = () => {
    
    return (
        <StyledProjectSearchDiv>
            <Condition />
        </StyledProjectSearchDiv>
    );
};

export default ProjectSearch;