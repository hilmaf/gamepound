import React from 'react';
import ProjectBoxInfo from '../../component/project/ProjectBoxInfo';
import styled from 'styled-components';

const StyledUserCreatedDiv = styled.div`
        padding-left: 20px;

        & > #cnt {
            height: 80px;
            line-height: 80px;
        }

        & > #project_items {
            width: 1050px;
            display: flex;
            flex-wrap: wrap;
        }
`;

const UserCreated = () => {
    return (
        <StyledUserCreatedDiv>
            <div id="cnt">프로젝트가 --n--개 있습니다.</div>
            <div id="project_items">
                <ProjectBoxInfo />
                <ProjectBoxInfo />
                <ProjectBoxInfo />
                <ProjectBoxInfo />
            </div>
        </StyledUserCreatedDiv>
    );
};

export default UserCreated;