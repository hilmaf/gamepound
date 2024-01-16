import React from 'react';
import styled from 'styled-components';
import ProjectBoxInfo from '../../../component/project/ProjectBoxInfo';

const StyledProjectSearchDiv = styled.div`
    width: 1200px;
    display: flex;
`;

const ProjectSearch = ({result}) => {
    return (
        <StyledProjectSearchDiv>
            {
                result.map((item)=> (
                    <ProjectBoxInfo no={4} project={item}/>
                ))
            }
        </StyledProjectSearchDiv>
    );
};

export default ProjectSearch;